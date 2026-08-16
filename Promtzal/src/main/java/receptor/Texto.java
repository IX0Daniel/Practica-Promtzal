package receptor;

/**
 * @author dz
 */
public class Texto {
 
  
    
    
    public void analizador(String entrada){
        
        String palabra = entrada;
        
        
        
        
        for(int i = 0; i < entrada.length(); i ++){
            
            char caracter = entrada.charAt(i);
            
            if(palabra.equals("token")){
               
                
                System.out.println("Palabra: token");
                return;
                
            
            }
            
            palabra = palabra + caracter;
            
        }
        
        System.out.println("La palabra no es un token?");
    }
            
            
            
            
}
