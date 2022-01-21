package br.com.adson.util;


class StandardException extends Exception {
    
    public StandardException() {
    
    }
    
    public StandardException(String arg0) {
        super(arg0);
    }
    
    public StandardException(Throwable arg0) {
        super(arg0);
    }
    
    public StandardException(String arg0, Throwable arg1) {
        super(arg0,arg1);
    }
    
}
