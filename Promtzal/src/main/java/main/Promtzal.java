package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import receptor.Texto;
import token.Token;

/**
 * @author dz
 */
public class Promtzal {
    
    

    private String textoEntrada;
    private List<String> lineas;

    public Promtzal() {
        
        lineas = new ArrayList<>();
        inicioAnalizador();
        
    }
    
    
    
    
    public void inicioAnalizador(){
    
        List<Token> tokens = new ArrayList<>();
        
        try {
            lineas = new LectorArchivo().leerArchivo();
        } catch (IOException ex) {
            System.getLogger(Promtzal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        Texto tokenizador = new Texto();
        
        int contadorLinea = 0;
        
        for (String linea: lineas) {
            tokens.addAll(tokenizador.analizador(linea, contadorLinea, 0));
            
            
        }
        
        
         
        for(Token token: tokens){

                        
            System.out.println("\nlexema: " + token.getLexema());                    
            System.out.println("tipo: " + token.getTipoToken());
            System.out.println("columna: " + token.getColumna());
            System.out.println("fila: " + token.getFila());
            
        
        }
    
    }
    
}
