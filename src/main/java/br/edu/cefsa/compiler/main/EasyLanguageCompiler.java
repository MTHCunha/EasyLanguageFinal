// Arquivo: src/br/edu/cefsa/compiler/main/EasyLanguageCompiler.java
package br.edu.cefsa.compiler.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import br.edu.cefsa.compiler.parser.*;
import br.edu.cefsa.compiler.exceptions.EasySemanticException;
import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EasyLanguageCompiler {
    
    public static class CompilationResult {
        private boolean success;
        private String message;
        private List<String> errors;
        private List<String> warnings;
        private String generatedCode;
        private EasySymbolTable symbolTable;
        
        public CompilationResult() {
            this.errors = new ArrayList<>();
            this.warnings = new ArrayList<>();
            this.success = false;
        }
        
        // Getters e setters
        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public List<String> getErrors() { return errors; }
        public void setErrors(List<String> errors) { this.errors = errors; }
        public List<String> getWarnings() { return warnings; }
        public void setWarnings(List<String> warnings) { this.warnings = warnings; }
        public String getGeneratedCode() { return generatedCode; }
        public void setGeneratedCode(String generatedCode) { this.generatedCode = generatedCode; }
        public EasySymbolTable getSymbolTable() { return symbolTable; }
        public void setSymbolTable(EasySymbolTable symbolTable) { this.symbolTable = symbolTable; }
        
        public void addError(String error) { this.errors.add(error); }
        public void addWarning(String warning) { this.warnings.add(warning); }
    }
    
    public static CompilationResult compile(String sourceCode) {
        CompilationResult result = new CompilationResult();
        
        try {
            // Análise Léxica
            ANTLRInputStream input = new ANTLRInputStream(sourceCode);
            EasyLanguageLexer lexer = new EasyLanguageLexer(input);
            
            // Captura erros léxicos
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                      int line, int charPositionInLine, String msg, RecognitionException e) {
                    result.addError("Erro Léxico na linha " + line + ":" + charPositionInLine + " - " + msg);
                }
            });
            
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Análise Sintática
            EasyLanguageParser parser = new EasyLanguageParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                      int line, int charPositionInLine, String msg, RecognitionException e) {
                    result.addError("Erro Sintático na linha " + line + ":" + charPositionInLine + " - " + msg);
                }
            });
            
            ParseTree tree = parser.prog();
            
            // Se não houve erros léxicos ou sintáticos, continua com análise semântica
            if (result.getErrors().isEmpty()) {
                try {
                    // Análise Semântica e geração de código
                    result.setSymbolTable(parser.symbolTable);
                    
                    // Verifica warnings semânticos
                    checkSemanticWarnings(parser.symbolTable, result);
                    
                    // Gera código se não houve erros
                    parser.generateCode();
                    result.setGeneratedCode(parser.program.generateJavaCode());
                    result.setSuccess(true);
                    result.setMessage("Compilação realizada com sucesso!");
                    
                } catch (EasySemanticException e) {
                    result.addError("Erro Semântico: " + e.getMessage());
                } catch (Exception e) {
                    result.addError("Erro durante geração de código: " + e.getMessage());
                }
            }
            
        } catch (Exception e) {
            result.addError("Erro geral: " + e.getMessage());
        }
        
        return result;
    }
    
    private static void checkSemanticWarnings(EasySymbolTable symbolTable, CompilationResult result) {
        // Verifica variáveis não utilizadas
        ArrayList<String> unusedVars = symbolTable.getUnusedVariables();
        for (String var : unusedVars) {
            result.addWarning("Variável '" + var + "' declarada mas nunca utilizada");
        }
        
        // Verifica variáveis não inicializadas
        ArrayList<String> uninitializedVars = symbolTable.getUninitializedVariables();
        for (String var : uninitializedVars) {
            result.addWarning("Variável '" + var + "' utilizada mas pode não ter sido inicializada");
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java EasyLanguageCompiler <arquivo.easy>");
            return;
        }
        
        try {
            String filename = args[0];
            String sourceCode = readFile(filename);
            
            CompilationResult result = compile(sourceCode);
            
            System.out.println("=== RESULTADO DA COMPILAÇÃO ===");
            System.out.println("Status: " + (result.isSuccess() ? "SUCESSO" : "FALHA"));
            System.out.println("Mensagem: " + result.getMessage());
            
            if (!result.getErrors().isEmpty()) {
                System.out.println("\n=== ERROS ===");
                for (String error : result.getErrors()) {
                    System.out.println("- " + error);
                }
            }
            
            if (!result.getWarnings().isEmpty()) {
                System.out.println("\n=== AVISOS ===");
                for (String warning : result.getWarnings()) {
                    System.out.println("- " + warning);
                }
            }
            
            if (result.isSuccess() && result.getGeneratedCode() != null) {
                System.out.println("\n=== CÓDIGO GERADO ===");
                System.out.println(result.getGeneratedCode());
                
                // Salva o código gerado
                String outputFile = filename.replace(".easy", ".java");
                writeFile(outputFile, result.getGeneratedCode());
                System.out.println("\nCódigo Java salvo em: " + outputFile);
            }
            
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
    
    private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    
    private static void writeFile(String filename, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.print(content);
        }
    }
}