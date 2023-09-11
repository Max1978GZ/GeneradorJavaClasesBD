/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generarbd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adminj
 */
public class GenerarBD {

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            
        try {
            GUI.Principal f = new GUI.Principal();       
            f.setVisible(true);
//     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenerarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
