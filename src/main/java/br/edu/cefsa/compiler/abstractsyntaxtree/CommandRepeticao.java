// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/CommandRepeticao.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> comandos;
    
    public CommandRepeticao(String condition, ArrayList<AbstractCommand> comandos) {
        this.condition = condition;
        this.comandos = comandos;
    }
    
    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("while (" + condition + ") {\n");
        for (AbstractCommand cmd : comandos) {
            str.append("\t" + cmd.generateJavaCode() + "\n");
        }
        str.append("}");
        return str.toString();
    }
    
    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("while " + condition + ":\n");
        for (AbstractCommand cmd : comandos) {
            str.append("\t" + cmd.generatePythonCode() + "\n");
        }
        return str.toString();
    }
    
    @Override
    public String generateCCode() {
        StringBuilder str = new StringBuilder();
        str.append("while (" + condition + ") {\n");
        for (AbstractCommand cmd : comandos) {
            str.append("\t" + cmd.generateCCode() + "\n");
        }
        str.append("}");
        return str.toString();
    }
    
    @Override
    public String toString() {
        return "CommandRepeticao [condition=" + condition + ", comandos=" + comandos.size() + "]";
    }
}