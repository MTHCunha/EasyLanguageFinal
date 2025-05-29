// Arquivo: src/br/edu/cefsa/compiler/datastructures/EasyFunction.java
package br.edu.cefsa.compiler.datastructures;

import java.util.ArrayList;

public class EasyFunction extends EasySymbol {
    private ArrayList<EasyVariable> parameters;
    private int returnType;
    private boolean hasReturn;
    
    public EasyFunction(String name, int returnType, ArrayList<EasyVariable> parameters) {
        super(name);
        this.returnType = returnType;
        this.parameters = parameters != null ? parameters : new ArrayList<>();
        this.hasReturn = false;
    }
    
    public ArrayList<EasyVariable> getParameters() {
        return parameters;
    }
    
    public void setParameters(ArrayList<EasyVariable> parameters) {
        this.parameters = parameters;
    }
    
    public int getReturnType() {
        return returnType;
    }
    
    public void setReturnType(int returnType) {
        this.returnType = returnType;
    }
    
    public boolean hasReturn() {
        return hasReturn;
    }
    
    public void setHasReturn(boolean hasReturn) {
        this.hasReturn = hasReturn;
    }
    
    public int getParameterCount() {
        return parameters.size();
    }
    
    public EasyVariable getParameter(int index) {
        if (index >= 0 && index < parameters.size()) {
            return parameters.get(index);
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EasyFunction [name=").append(name);
        sb.append(", returnType=").append(returnType);
        sb.append(", parameters=").append(parameters.size());
        sb.append("]");
        return sb.toString();
    }
}