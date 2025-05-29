// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/CommandEscrita.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

public class CommandEscrita extends AbstractCommand {
    private String id;
    
    public CommandEscrita(String id) {
        this.id = id;
    }
    
    @Override
    public String generateJavaCode() {
        return "System.out.println(" + id + ");";
    }
    
    @Override
    public String generatePythonCode() {
        return "print(" + id + ")";
    }
    
    @Override
    public String generateCCode() {
        return "printf(\"%s\\n\", " + id + ");";
    }
    
    @Override
    public String toString() {
        return "CommandEscrita [id=" + id + "]";
    }
}