package br.edu.cefsa.compiler.datastructures;

public abstract class EasySymbol {
    protected String name;
    protected int type;
    protected boolean used;        // Novo campo para rastrear se o símbolo foi usado
    protected boolean initialized; // Novo campo para rastrear se o símbolo foi inicializado
    protected int line;            // Novo campo para armazenar a linha do símbolo

    public EasySymbol(String name) {
        this.name = name;
        this.used = false;        // Valor padrão: símbolo não usado
        this.initialized = false; // Valor padrão: símbolo não inicializado
        this.line = -1;           // Valor padrão: linha não definida
    }

    public EasySymbol(String name, int type) {
        this.name = name;
        this.type = type;
        this.used = false;        // Valor padrão: símbolo não usado
        this.initialized = false; // Valor padrão: símbolo não inicializado
        this.line = -1;           // Valor padrão: linha não definida
    }

    public EasySymbol(String name, int type, int line) {
        this.name = name;
        this.type = type;
        this.line = line;         // Define a linha do símbolo
        this.used = false;        // Valor padrão: símbolo não usado
        this.initialized = false; // Valor padrão: símbolo não inicializado
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "EasySymbol [name=" + name + ", type=" + type + ", used=" + used + 
               ", initialized=" + initialized + ", line=" + line + "]";
    }
}