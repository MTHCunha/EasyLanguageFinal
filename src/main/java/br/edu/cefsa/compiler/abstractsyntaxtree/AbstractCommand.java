// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/AbstractCommand.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

public abstract class AbstractCommand {
    
    public abstract String generateJavaCode();
    
    public abstract String generatePythonCode();
    
    public abstract String generateCCode();
    
    @Override
    public abstract String toString();
}