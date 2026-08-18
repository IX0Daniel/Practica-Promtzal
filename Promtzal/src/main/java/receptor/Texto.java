package receptor;

import java.util.ArrayList;
import java.util.List;
import token.LexemaToken;
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
        char caracter;
        TokenData analizarDirecivas;
        
        List<Token> tokens = new ArrayList();
        
        
         
        for(int i = columna; i < entrada.length(); i ++){
            
            caracter = entrada.charAt(i);

            //System.out.print("\nposición actual: " + i + " - " + caracter);

            
            switch (caracter) {
                case 64:
                    //en este caso se verificará si el lexema pertenece a una directiva
                    analizarDirecivas = analizarDirecivas(entrada, i, fila);
                    i = analizarDirecivas.getColumna();
                    
                    //System.out.println("se validó un posible direvtiva, ahora se continua en la columna: " + i);
                    tokens.add(analizarDirecivas.getToken());
                    
                    continue;
                case 32:
                    //verificar espacios, si es, entonces continuar iterando
                    
                    //System.out.println("Se detectó un espacio vacío");
                    continue;
                  
                default:
                    
                //en estos casos se identifican palabras
                    
                    
                    //posible salto de línea
                    boolean saltoLinea;
                    saltoLinea = analizarSaltoLinea(caracter);
                    
                    if(saltoLinea){
                        return tokens;
                    }
                    
                    //verificat si son letras, si no entonces verificar conectores
                    if(caracter >= 65 && caracter <= 90){
                    
                        analizarDirecivas = analizarPalabras(entrada, i, fila);
                        i = analizarDirecivas.getColumna();

                        //System.out.println("se validó un posible palabra, ahora se continua en la columna: " + i);
                        tokens.add(analizarDirecivas.getToken());
                         

                        
                        
                    }else if(caracter >= 97 && caracter <= 122){
                        analizarDirecivas = analizarPalabras(entrada, i, fila);
                        i = analizarDirecivas.getColumna();

                    
                        //System.out.println("se validó un posible palabra, ahora se continua en la columna: " + i);
                        tokens.add(analizarDirecivas.getToken());

                        
                    
                    }else{
                    
                        
                        
                        //verificar caracteres especiales 
                        LexemaToken lexemaToken = new LexemaToken();
                        
                        Token token = new Token(0, Character.toString(caracter), lexemaToken.analizarCaracter(caracter), fila, i);
                        
                        
                               
                        //TokenData tokenTemporal = new TokenData(token, fila, columna);

                         
                        
                        
                              
                        if(token.getLexema().equals("\"")){
                            
                            System.out.println("se va a evaluar el comentario");
                        
                            analizarDirecivas = analizarComentario(token, entrada, fila, i);
                            
                            i = analizarDirecivas.getColumna();
                            
                            
                        
                        }
                        tokens.add(token);
                        
                        continue;
                    
                    }
                
                    break;

            }
            
        }
        
         
        
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
                //System.out.println("caracter vacio");
                break;
            }
            
            
             
            directiva = directiva + caracter;
            
            posicionFinal = i;
            
    

        }
        
         
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
    
    
    private TokenData analizarPalabras(String entrada, int posicion, int fila){
        Token token;
        String lexema = "";
        char caracter = 0;
        int posicionFinal = posicion;
        
        if(posicion+1 < entrada.length()){
        
            if(analizarSaltoLinea(entrada.charAt(posicion+1))){
                posicionFinal++;
                return new TokenData(new Token(0, Character.toString(entrada.charAt(posicion)), TipoToken.IDENTIFICADOR, fila, posicion), fila, posicion);

            }
            //verificar si después de letra hay un espacio ' '
            if(entrada.charAt(posicion+1) == 32){                 
                posicionFinal++;            
                return new TokenData(new Token(0, Character.toString(entrada.charAt(posicion)), TipoToken.IDENTIFICADOR, fila, posicion), fila, posicion);
            }

        
        }
        
        
        //verificar si después de letra hay un salto de línea        
        for(int i = posicion; i < entrada.length(); i ++){
        
            
            
            if(i == entrada.length()){
                break;
            }
            
            caracter = entrada.charAt(i);
            
            if(caracter == 32){
                //se detiene cuando hay un espacio vació
                //System.out.println("caracter vacio");
                 
                break;
            }
            
            //verificar si es letra o _ - y numero para posibles identificadoes
            
            if(Character.isLetter(caracter) == false && Character.isDigit(caracter) == false && caracter != '_'){
                //System.out.println("El siguiente caracter " + caracter + "no sirve para formar un identificador");
                
                break;
            }
            
            lexema = lexema + caracter;
            
            
            
            //System.out.println("caracter actual: " + caracter);
    
            posicionFinal++; 
        }
        
        //clasificar Palabras
               
        posicionFinal--;
        
        //System.out.println("posición actual: " + posicionFinal);        
        
        return new TokenData(new Token(0, lexema, new LexemaToken().analizarToken(lexema), fila, posicion), fila, posicionFinal);
 
    
    }
    
    private boolean analizarSaltoLinea(char salto){
        
        if(salto == '\n'){
            return true;
        }
        return false;
    }
    
    private TokenData analizarCaracter(char lexema){
        return null;
    }

    private TokenData analizarComentario(Token token, String entrada, int fila, int columna) {
        
    
        String lexema = token.getLexema();
        System.out.println(" el lexema es: " + lexema);
        
        lexema = "";
        
        for(int i= columna; i<entrada.length(); i++){
                             
        
            lexema = lexema + entrada.charAt(i);
            
            System.out.println("Lexema analizado; " + lexema);
            
            if(Character.toString(entrada.charAt(i)).equals("\"") && lexema.length() >1){
                //en este caso necesito devolcer un nuevo tokenData
                
                token.setLexema(lexema);
                
                return new TokenData(token, fila, i);
            
            }
            
            
        
            
        }
        
        
        token.setTipoToken(TipoToken.ERROR);
        
        return new TokenData(token, fila, entrada.length());
    }
    
    
}