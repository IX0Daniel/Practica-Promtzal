package token;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dz
 */
public class LexemaToken {
    
    
   private List<TokenRegistrado> tokens;
   private List<TokenRegistrado> directivas;

    public LexemaToken() {
        
        tokens = new ArrayList<>();
        directivas = new ArrayList<>();
        
        tokens();
        
    }

    private void tokens() {
        
        directivas.add(new TokenRegistrado("@model", TipoToken.DIRECTIVA));
        directivas.add(new TokenRegistrado("@rol", TipoToken.DIRECTIVA));
        directivas.add(new TokenRegistrado("@formato", TipoToken.DIRECTIVA));
        

        tokens.add(new TokenRegistrado("AGENTE", TipoToken.PALABRA_RESERVADA));
        tokens.add(new TokenRegistrado("contexto", TipoToken.PALABRA_RESERVADA));
        tokens.add(new TokenRegistrado("variable", TipoToken.PALABRA_RESERVADA));
        tokens.add(new TokenRegistrado("EJECUTAR", TipoToken.PALABRA_RESERVADA));
        tokens.add(new TokenRegistrado("EXPORTAR", TipoToken.PALABRA_RESERVADA));
        
        tokens.add(new TokenRegistrado("PREGUNTAR", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("GENERAR", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("RESUMIR", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("ANALIZAR", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("TRADUCIR", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("CLASIFICAR", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("EXRTAER", TipoToken.COMANDO_IA));
        tokens.add(new TokenRegistrado("CARGAR", TipoToken.COMANDO_IA));

        tokens.add(new TokenRegistrado("SOBRE", TipoToken.CONECTOR));
        tokens.add(new TokenRegistrado("DESDE", TipoToken.CONECTOR));
        tokens.add(new TokenRegistrado("EN", TipoToken.CONECTOR));
        tokens.add(new TokenRegistrado("PREGUNTAR", TipoToken.CONECTOR));
        tokens.add(new TokenRegistrado("COMO", TipoToken.CONECTOR));
        tokens.add(new TokenRegistrado("->", TipoToken.CONECTOR));


        
    }    
    
    
    
    
    
    
    
}
