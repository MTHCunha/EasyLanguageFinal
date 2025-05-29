// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/CommandFor.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;

public class CommandFor extends AbstractCommand {
    private String var;
    private String expression;
    private ArrayList<AbstractCommand> comandos;
    
    public CommandFor(String var, String expression, ArrayList<AbstractCommand> comandos) {
        this.var = var;
        this.expression = expression;
        this.comandos = comandos;
    }
    
    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("for (" + var + " = " + expression + ") {\n");
        for (AbstractCommand cmd : comandos) {
            str.append("\t" + cmd.generateJavaCode() + "\n");
        }
        str.append("}");
        return str.toString();
    }
    
    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("for " + var + " in range(" + expression + "):\n");
        for (AbstractCommand cmd : comandos) {
            str.append("\t" + cmd.generatePythonCode() + "\n");
        }
        return str.toString();
    }
    
    @Override
    public String generateCCode() {
        StringBuilder str = new StringBuilder();
        str.append("for (" + var + " = " + expression + ") {\n");
        for (AbstractCommand cmd : comandos) {
            str.append("\t" + cmd.generateCCode() + "\n");
        }
        str.append("}");
        return str.toString();
    }
    
    @Override
    public String toString() {
        return "CommandFor [var=" + var + ", expression=" + expression + ", comandos=" + comandos.size() + "]";
    }
}