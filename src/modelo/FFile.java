/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author zeus
 */
public class FFile {

    public FFile() {
    }
    
    
    public static int saveFile(String ruta,String nombre, String contenido) throws IOException{
        //System.out.println(tabla + "    " + ruta);
        // crear directorio DAO
        
        File folder = new File(ruta);
        folder.mkdirs();
        ruta =ruta+nombre;
        File file = new File(ruta);
     
        if (file.exists()) {
           ruta+="new";
        }
        
        java.io.FileWriter f;
        java.io.BufferedWriter writer=null;
        try {
            f = new java.io.FileWriter(ruta);

            writer = new java.io.BufferedWriter(f);

            writer.write(contenido);
            writer.flush();
            writer.close();
            return 1;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
          writer.close();
          
          
        }        
       
      
    }
    
  public static void crearDir(String nombre){
      
       File folder = new File(nombre);
       folder.mkdirs();
      
  }
    
    
    
}
