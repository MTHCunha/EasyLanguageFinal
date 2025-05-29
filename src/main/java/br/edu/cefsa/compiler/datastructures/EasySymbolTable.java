// Arquivo: src/br/edu/cefsa/compiler/datastructures/EasySymbolTable.java
package br.edu.cefsa.compiler.datastructures;

import java.util.HashMap;
import java.util.ArrayList;

public class EasySymbolTable {
    private HashMap<String, EasySymbol> map;
    
    public EasySymbolTable() {
        map = new HashMap<String, EasySymbol>();
    }
    
    public void add(EasySymbol symbol) {
        map.put(symbol.getName(), symbol);
    }
    
    public boolean exists(String symbolName) {
        return map.containsKey(symbolName);
    }
    
    public EasySymbol get(String symbolName) {
        return map.get(symbolName);
    }
    
    public ArrayList<EasySymbol> getAll() {
        ArrayList<EasySymbol> lista = new ArrayList<EasySymbol>();
        for (EasySymbol symbol : map.values()) {
            lista.add(symbol);
        }
        return lista;
    }
    
    public void remove(String symbolName) {
        map.remove(symbolName);
    }
    
    public void clear() {
        map.clear();
    }
    
    public int size() {
        return map.size();
    }
    
    // Método para verificar variáveis não utilizadas
    public ArrayList<String> getUnusedVariables() {
        ArrayList<String> unused = new ArrayList<>();
        for (EasySymbol symbol : map.values()) {
            if (symbol instanceof EasyVariable) {
                EasyVariable var = (EasyVariable) symbol;
                if (!var.isUsed()) {
                    unused.add(var.getName());
                }
            }
        }
        return unused;
    }
    
    // Método para verificar variáveis não inicializadas
    public ArrayList<String> getUninitializedVariables() {
        ArrayList<String> uninitialized = new ArrayList<>();
        for (EasySymbol symbol : map.values()) {
            if (symbol instanceof EasyVariable) {
                EasyVariable var = (EasyVariable) symbol;
                if (var.isUsed() && !var.isInitialized()) {
                    uninitialized.add(var.getName());
                }
            }
        }
        return uninitialized;
    }
    
    @Override
    public String toString() {
        return "EasySymbolTable [symbols=" + map.size() + "]";
    }
}