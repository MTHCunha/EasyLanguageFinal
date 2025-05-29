// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/EasyProgram.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;
import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
import br.edu.cefsa.compiler.datastructures.EasyVariable;
import br.edu.cefsa.compiler.datastructures.EasySymbol;

public class EasyProgram {
    private EasySymbolTable varTable;
    private ArrayList<AbstractCommand> comandos;
    private String filename;
    
    public EasyProgram() {
        comandos = new ArrayList<AbstractCommand>();
    }
    
    public void generateTarget() {
        generateJavaCode();
    }
    
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass {\n");
        str.append("\tpublic static void main(String args[]) {\n");
        str.append("\t\tScanner _key = new Scanner(System.in);\n");
        
        // Declaração de variáveis
        for (EasySymbol symbol : varTable.getAll()) {
            if (symbol instanceof EasyVariable) {
                EasyVariable var = (EasyVariable) symbol;
                str.append("\t\t");
                switch (var.getType()) {
                    case EasyVariable.INTEGER:
                        str.append("int ");
                        break;
                    case EasyVariable.REAL:
                        str.append("float ");
                        break;
                    case EasyVariable.TEXT:
                        str.append("String ");
                        break;
                    case EasyVariable.BOOLEAN:
                        str.append("boolean ");
                        break;
                    case EasyVariable.CHAR:
                        str.append("char ");
                        break;
                }
                str.append(var.getName());
                if (var.getValue() != null) {
                    str.append(" = " + var.getValue());
                }
                str.append(";\n");
            }
        }
        
        // Comandos
        for (AbstractCommand command : comandos) {
            str.append("\t\t" + command.generateJavaCode() + "\n");
        }
        
        str.append("\t}\n");
        str.append("}\n");
        
        return str.toString();
    }
    
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        
        // Declaração de variáveis
        for (EasySymbol symbol : varTable.getAll()) {
            if (symbol instanceof EasyVariable) {
                EasyVariable var = (EasyVariable) symbol;
                if (var.getValue() != null) {
                    str.append(var.getName() + " = " + var.getValue() + "\n");
                }
            }
        }
        
        // Comandos
        for (AbstractCommand command : comandos) {
            str.append(command.generatePythonCode() + "\n");
        }
        
        return str.toString();
    }
    
    public String generateCCode() {
        StringBuilder str = new StringBuilder();
        str.append("#include <stdio.h>\n");
        str.append("#include <stdlib.h>\n");
        str.append("int main() {\n");
        
        // Declaração de variáveis
        for (EasySymbol symbol : varTable.getAll()) {
            if (symbol instanceof EasyVariable) {
                EasyVariable var = (EasyVariable) symbol;
                str.append("\t");
                switch (var.getType()) {
                    case EasyVariable.INTEGER:
                        str.append("int ");
                        break;
                    case EasyVariable.REAL:
                        str.append("float ");
                        break;
                    case EasyVariable.TEXT:
                        str.append("char ");
                        break;
                    case EasyVariable.CHAR:
                        str.append("char ");
                        break;
                }
                str.append(var.getName());
                if (var.getValue() != null) {
                    str.append(" = " + var.getValue());
                }
                str.append(";\n");
            }
        }
        
        // Comandos
        for (AbstractCommand command : comandos) {
            str.append("\t" + command.generateCCode() + "\n");
        }
        
        str.append("\treturn 0;\n");
        str.append("}\n");
        
        return str.toString();
    }
    
    public EasySymbolTable getVarTable() {
        return varTable;
    }
    
    public void setVarTable(EasySymbolTable varTable) {
        this.varTable = varTable;
    }
    
    public ArrayList<AbstractCommand> getComandos() {
        return comandos;
    }
    
    public void setComandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }
    
    public String getFilename() {
        return filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
}