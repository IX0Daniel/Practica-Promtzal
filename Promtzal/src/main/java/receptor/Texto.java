package receptor;

import java.util.ArrayList;
import java.util.List;
import token.TipoToken;
import token.Token;
import token.TokenData;

/**
 * @author dz
 */
public class Texto {
    
    
    //Líneas iniciales
    public List<Token> analizador(String entrada, int fila, int columna){
        
        String lexema = entrada; 
        char caracter = entrada.charAt(0);
        
        List<Token> tokens = new ArrayList();
        
        
        System.out.println("tamaño :" + entrada.length());
        for(int i = columna; i < entrada.length(); i ++){
            
            System.out.println("posición actual: " + i);
            caracter = entrada.charAt(i);
            
            switch (caracter) {
                case 64:
                    //en este caso se verificará si el lexema pertenece a una directiva
                    TokenData analizarDirecivas = analizarDirecivas(entrada, i, fila);
                    i = analizarDirecivas.getColumna();
                    
                    System.out.println("se validó un posible direvtiva, ahora se continua en la columna: " + i);
                    tokens.add(analizarDirecivas.getToken());
                    
                    continue;
                case 32:
                    //verificar espacios, si es, entonces continuar iterando
                    
                    System.out.println("Se detectó un espacio vacío");
                    continue;
                  
                default:
                    System.out.println("El resto son letras :VV:V:V:");
                    break;
            }
            
        }
        
        System.out.println("La palabra no es un token?");
        
        return tokens;
    }
        
    
    
    private TokenData analizarDirecivas(String entrada, int posicion, int fila){
        Token token;
        String directiva = "";
        char caracter = 0;
        int posicionFinal = 0;
        
        //verificar si después de @ hay un salto de línea
        if(analizarSaltoLinea(entrada.charAt(posicion+1))){
            posicionFinal++;
            return new TokenData(new Token(0, "@", TipoToken.ERROR, fila, posicion), fila, posicion);
            
        }
        //verificar si después de @ hay un espacio ' '
        if(entrada.charAt(posicion+1) == 32){                 
            posicionFinal++;            
            return new TokenData(new Token(0, "@", TipoToken.ERROR, fila, posicion), fila, posicion);
        }
        
        for(int i = posicion; i < entrada.length(); i ++){
        
            if(i == entrada.length()){
                break;
            }
            
           


            
            caracter = entrada.charAt(i);
            
            if(caracter == 32){
                System.out.println("caracter vacio");
                break;
            }
            
            
            directiva = directiva + caracter;
            
            posicionFinal = i;
            
            System.out.println("caracter actual: " + caracter);
            
            
            

        }
        
        System.out.println("posición actual: " + posicionFinal);
        
        switch (directiva) {
            case "@modelo":
                     
                     
                return new TokenData(new Token(0, directiva, TipoToken.DIRECTIVA, fila, posicion), fila, posicionFinal);

                 
                
            case "@rol":                            
                return new TokenData(new Token(0, directiva, TipoToken.DIRECTIVA, fila, posicion), fila, posicionFinal);


                
            case "@formato":

                return new TokenData(new Token(0, directiva, TipoToken.DIRECTIVA, fila, posicion), fila, posicionFinal);

            default:
              
                return new TokenData(new Token(0, directiva, TipoToken.ERROR, fila, posicion), fila, posicionFinal);

        }
    
    }
    
    private boolean analizarSaltoLinea(char salto){
        
        if(salto == '\n'){
            return true;
        
        }
                            
    
        return false;
    }
} 