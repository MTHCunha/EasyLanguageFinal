// Arquivo: src/br/edu/cefsa/compiler/servlet/CompilerServlet.java
package br.edu.cefsa.compiler.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import com.google.gson.Gson;
import br.edu.cefsa.compiler.main.EasyLanguageCompiler;
import br.edu.cefsa.compiler.main.EasyLanguageCompiler.CompilationResult;
import br.edu.cefsa.compiler.datastructures.EasySymbol;
import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
import java.util.*;

@WebServlet("/compile")
public class CompilerServlet extends HttpServlet {
    
    private Gson gson = new Gson();
    
    // Classe para resposta JSON
    public static class CompilerResponse {
        private boolean success;
        private String message;
        private List<String> errors;
        private List<String> warnings;
        private String generatedCode;
        private List<SymbolTableEntry> symbolTable;
        
        public CompilerResponse() {
            this.errors = new ArrayList<>();
            this.warnings = new ArrayList<>();
            this.symbolTable = new ArrayList<>();
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
        public List<SymbolTableEntry> getSymbolTable() { return symbolTable; }
        public void setSymbolTable(List<SymbolTableEntry> symbolTable) { this.symbolTable = symbolTable; }
    }
    
    // Classe para entrada da tabela de símbolos
    public static class SymbolTableEntry {
        private String name;
        private String type;
        private boolean used;
        private boolean initialized;
        private int line;
        
        public SymbolTableEntry(String name, String type, boolean used, boolean initialized, int line) {
            this.name = name;
            this.type = type;
            this.used = used;
            this.initialized = initialized;
            this.line = line;
        }
        
        // Getters
        public String getName() { return name; }
        public String getType() { return type; }
        public boolean isUsed() { return used; }
        public boolean isInitialized() { return initialized; }
        public int getLine() { return line; }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Configurar CORS se necessário
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        CompilerResponse compilerResponse = new CompilerResponse();
        
        try {
            // Ler o código fonte do request
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            
            String sourceCode = sb.toString().trim();
            
            if (sourceCode.isEmpty()) {
                compilerResponse.setSuccess(false);
                compilerResponse.setMessage("Código fonte vazio");
                compilerResponse.getErrors().add("Por favor, forneça código para compilar");
            } else {
                // Compilar usando o EasyLanguageCompiler
                CompilationResult result = EasyLanguageCompiler.compile(sourceCode);
                
                // Converter resultado para resposta HTTP
                compilerResponse.setSuccess(result.isSuccess());
                compilerResponse.setMessage(result.getMessage());
                compilerResponse.setErrors(result.getErrors());
                compilerResponse.setWarnings(result.getWarnings());
                compilerResponse.setGeneratedCode(result.getGeneratedCode());
                
                // Converter tabela de símbolos
                if (result.getSymbolTable() != null) {
                    convertSymbolTable(result.getSymbolTable(), compilerResponse);
                }
            }
            
        } catch (Exception e) {
            compilerResponse.setSuccess(false);
            compilerResponse.setMessage("Erro interno do servidor");
            compilerResponse.getErrors().add("Erro: " + e.getMessage());
            e.printStackTrace(); // Para debug
        }
        
        // Enviar resposta JSON
        String jsonResponse = gson.toJson(compilerResponse);
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
    
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Para suporte CORS
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    
    private void convertSymbolTable(EasySymbolTable symbolTable, CompilerResponse response) {
        try {
            // Assumindo que EasySymbolTable tem métodos para acessar os símbolos
            // Você pode precisar ajustar isso baseado na sua implementação real
            
            for (EasySymbol symbol : symbolTable.getAll()) {
                SymbolTableEntry entry = new SymbolTableEntry(
                    symbol.getName(),
                    String.valueOf(symbol.getType()),
                    symbol.isUsed(),
                    symbol.isInitialized(),
                    symbol.getLine()
                );
                response.getSymbolTable().add(entry);
            }
        } catch (Exception e) {
            // Se não conseguir converter a tabela de símbolos, continua sem ela
            System.err.println("Erro ao converter tabela de símbolos: " + e.getMessage());
        }
    }
}