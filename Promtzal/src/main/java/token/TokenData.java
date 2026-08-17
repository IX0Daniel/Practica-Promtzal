 package token;

/** 
 * @author dz
 */
public class TokenData {
    private Token token;
    private int fila;
    private int columna;

    public TokenData(Token token, int fila, int columna) {
        this.token = token;
        this.fila = fila;
        this.columna = columna;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
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
