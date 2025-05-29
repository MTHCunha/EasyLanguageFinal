// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/CommandAtribuicao.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

public class CommandAtribuicao extends AbstractCommand {
    private String id;
    private String expr;
    
    public CommandAtribuicao(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }
    
    @Override
    public String generateJavaCode() {
        return id + " = " + expr + ";";
    }
    
    @Override
    public String generatePythonCode() {
        return id + " = " + expr;
    }
    
    @Override
    public String generateCCode() {
        return id + " = " + expr + ";";
    }
    
    @Override
    public String toString() {
        return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
    }
}