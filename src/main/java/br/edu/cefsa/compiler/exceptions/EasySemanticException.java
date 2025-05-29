// Arquivo: src/br/edu/cefsa/compiler/exceptions/EasySemanticException.java
package br.edu.cefsa.compiler.exceptions;

@SuppressWarnings("serial")
public class EasySemanticException extends RuntimeException {
    
    public EasySemanticException() {
        super();
    }
    
    public EasySemanticException(String message) {
        super(message);
    }
    
    public EasySemanticException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public EasySemanticException(Throwable cause) {
        super(cause);
    }
}