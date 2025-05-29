// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/CommandDecisao.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;
    
    public CommandDecisao(String condition, ArrayList<AbstractCommand> listaTrue, ArrayList<AbstractCommand> listaFalse) {
        this.condition = condition;
        this.listaTrue = listaTrue;
        this.listaFalse = listaFalse;
    }
    
    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("if (" + condition + ") {\n");
        for (AbstractCommand cmd : listaTrue) {
            str.append("\t" + cmd.generateJavaCode() + "\n");
        }
        str.append("}");
        if (listaFalse != null && !listaFalse.isEmpty()) {
            str.append(" else {\n");
            for (AbstractCommand cmd : listaFalse) {
                str.append("\t" + cmd.generateJavaCode() + "\n");
            }
            str.append("}");
        }
        return str.toString();
    }
    
    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        str.append("if " + condition + ":\n");
        for (AbstractCommand cmd : listaTrue) {
            str.append("\t" + cmd.generatePythonCode() + "\n");
        }
        if (listaFalse != null && !listaFalse.isEmpty()) {
            str.append("else:\n");
            for (AbstractCommand cmd : listaFalse) {
                str.append("\t" + cmd.generatePythonCode() + "\n");
            }
        }
        return str.toString();
    }
    
    @Override
    public String generateCCode() {
        StringBuilder str = new StringBuilder();
        str.append("if (" + condition + ") {\n");
        for (AbstractCommand cmd : listaTrue) {
            str.append("\t" + cmd.generateCCode() + "\n");
        }
        str.append("}");
        if (listaFalse != null && !listaFalse.isEmpty()) {
            str.append(" else {\n");
            for (AbstractCommand cmd : listaFalse) {
                str.append("\t" + cmd.generateCCode() + "\n");
            }
            str.append("}");
        }
        return str.toString();
    }
    
    @Override
    public String toString() {
        return "CommandDecisao [condition=" + condition + ", true=" + listaTrue.size() + ", false=" + (listaFalse != null ? listaFalse.size() : 0) + "]";
    }
}