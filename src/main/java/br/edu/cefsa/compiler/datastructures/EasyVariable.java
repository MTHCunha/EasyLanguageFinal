// Arquivo: src/br/edu/cefsa/compiler/datastructures/EasyVariable.java
package br.edu.cefsa.compiler.datastructures;

public class EasyVariable extends EasySymbol {
    public static final int INTEGER = 0;
    public static final int REAL = 1;
    public static final int TEXT = 2;
    public static final int CHAR = 3;
    public static final int BOOLEAN = 4;
    public static final int ARRAY = 5;
    
    private String value;
    private boolean initialized;
    private boolean used;
    
    public EasyVariable() {
        super("");
    }
    
    public EasyVariable(String name) {
        super(name);
        this.initialized = false;
        this.used = false;
    }
    
    public EasyVariable(String name, int type) {
        super(name, type);
        this.initialized = false;
        this.used = false;
    }
    
    public EasyVariable(String name, int type, String value) {
        super(name, type);
        this.value = value;
        this.initialized = (value != null);
        this.used = false;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
        this.initialized = true;
    }
    
    public boolean isInitialized() {
        return initialized;
    }
    
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public void setUsed(boolean used) {
        this.used = used;
    }
    
    public String getTypeString() {
        switch(type) {
            case INTEGER: return "inteiro";
            case REAL: return "real";
            case TEXT: return "texto";
            case CHAR: return "caractere";
            case BOOLEAN: return "logico";
            case ARRAY: return "vetor";
            default: return "desconhecido";
        }
    }
    
    @Override
    public String toString() {
        return "EasyVariable [name=" + name + ", type=" + getTypeString() + 
               ", value=" + value + ", initialized=" + initialized + "]";
    }
}