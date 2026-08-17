package token;

/**
 * @author dz
 */
public class Token {
    
    
     
    private int numeroToken;
    private String lexema;
    private TipoToken tipoToken;
    private int fila;
    private int columna;

    public Token(int numeroToken, String lexema, TipoToken tipoToken, int fila, int columna) {
        this.numeroToken = numeroToken;
        this.lexema = lexema;
        this.tipoToken = tipoToken;
        this.fila = fila;
        this.columna = columna;
    }

    public int getNumeroToken() {
        return numeroToken;
    }

    public void setNumeroToken(int numeroToken) {
        this.numeroToken = numeroToken;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public TipoToken getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoToken tipoToken) {
        this.tipoToken = tipoToken;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
          
    
    
    
    
    
}
