package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dz
 */
public class LectorArchivo {
    
    private String ruta;
    
    public List<String> leerArchivo() throws IOException{
        
        ruta = pedirRuta();
        
        List<String> lineas = new ArrayList<>();
        
         
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                //contenido.append(linea).append("\n");
            }
        }
 
        return lineas;
 
        
    }

    private String pedirRuta() {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese la ruta del archivo de entrada: ");
                
        return entrada.nextLine();
    }
    
    
}
