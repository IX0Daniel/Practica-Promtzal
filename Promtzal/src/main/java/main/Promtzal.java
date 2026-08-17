 package main;

import java.util.List;
import receptor.Texto;
import token.Token;

/** 
 * @author dz
 */
public class Promtzal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        Texto tokenizador = new Texto();
        
        List<Token> analizador = tokenizador.analizador(" @rol @ @rol @@ @modelo ppppq @formato ", 0, 0);
        
        for(Token tokens: analizador){
        
            System.out.println("tipo: " + tokens.getTipoToken());
            System.out.println("lexema: " + tokens.getLexema());
            System.out.println("columna: " + tokens.getColumna());
            
        
        }
                
    }
}
