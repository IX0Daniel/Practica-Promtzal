package token;

/**
 *
 * @author dz
 */
public class TokenRegistrado {
    
    private String token;
    private TipoToken tipo;

    public TokenRegistrado(String token, TipoToken tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public TipoToken getTipo() {
        return tipo;
    }
    
    
    
    
}
