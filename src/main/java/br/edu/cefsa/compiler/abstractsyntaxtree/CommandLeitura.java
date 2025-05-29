// Arquivo: src/br/edu/cefsa/compiler/abstractsyntaxtree/CommandLeitura.java
package br.edu.cefsa.compiler.abstractsyntaxtree;

import br.edu.cefsa.compiler.datastructures.EasyVariable;

public class CommandLeitura extends AbstractCommand {
    private String id;
    private EasyVariable var;
    
    public CommandLeitura(String id, EasyVariable var) {
        this.id = id;
        this.var = var;
    }
    
    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        switch (var.getType()) {
            case EasyVariable.INTEGER:
                str.append(id + " = _key.nextInt();");
                break;
            case EasyVariable.REAL:
                str.append(id + " = _key.nextFloat();");
                break;
            case EasyVariable.TEXT:
                str.append(id + " = _key.nextLine();");
                break;
            case EasyVariable.BOOLEAN:
                str.append(id + " = _key.nextBoolean();");
                break;
        }
        return str.toString();
    }
    
    @Override
    public String generatePythonCode() {
        StringBuilder str = new StringBuilder();
        switch (var.getType()) {
            case EasyVariable.INTEGER:
                str.append(id + " = int(input())");
                break;
            case EasyVariable.REAL:
                str.append(id + " = float(input())");
                break;
            case EasyVariable.TEXT:
                str.append(id + " = input()");
                break;
            case EasyVariable.BOOLEAN:
                str.append(id + " = bool(input())");
                break;
        }
        return str.toString();
    }
    
    @Override
    public String generateCCode() {
        StringBuilder str = new StringBuilder();
        switch (var.getType()) {
            case EasyVariable.INTEGER:
                str.append("scanf(\"%d\", &" + id + ");");
                break;
            case EasyVariable.REAL:
                str.append("scanf(\"%f\", &" + id + ");");
                break;
            case EasyVariable.TEXT:
                str.append("scanf(\"%s\", " + id + ");");
                break;
        }
        return str.toString();
    }
    
    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + ", var=" + var + "]";
    }
}