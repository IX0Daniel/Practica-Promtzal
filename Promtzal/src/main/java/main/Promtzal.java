package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
            tokens.addAll(tokenizador.analizador(linea, contadorLinea, contadorLinea));
            contadorLinea++;
            
        }
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Reportes.html"));

            writer.write("<!DOCTYPE html>");
            writer.newLine();

            writer.write("<html>");
            writer.newLine();

            writer.write("<head>");
            writer.newLine();

            writer.write("<meta charset=\"UTF-8\">");
            writer.newLine();

            writer.write("<title>Análisis Léxico</title>");
            writer.newLine();

            writer.write("</head>");
            writer.newLine();

            writer.write("<body>");
            writer.newLine();

            writer.write("<table border=\"1\">");
            writer.newLine();

            
            writer.write("<tr>");
            writer.newLine();

            writer.write("<th>Lexema</th>");
            writer.write("<th>Tipo</th>");
            writer.write("<th>Fila</th>");
            writer.write("<th>Columna</th>");

            writer.write("</tr>");
            writer.newLine();

             
             
            for (Token token: tokens) {

                writer.write("<tr>");
                writer.newLine();

                writer.write("<td>" + token.getLexema() + "</td>");
                writer.write("<td>" + token.getTipoToken() + "</td>");
                writer.write("<td>" + token.getFila() + "</td>");
                writer.write("<td>" + token.getColumna() + "</td>");

                writer.write("</tr>");
                writer.newLine();
            }
     

            writer.write("</table>");
            writer.newLine();

            writer.write("</body>");
            writer.newLine();

            writer.write("</html>");
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
         
        for(Token token: tokens){

                        
            System.out.println("\nlexema: " + token.getLexema());                    
            System.out.println("tipo: " + token.getTipoToken());
            System.out.println("columna: " + token.getColumna());
            System.out.println("fila: " + token.getFila());
            
        
        }
    
    }
    
}
