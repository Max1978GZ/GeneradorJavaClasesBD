/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametros;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author zeus
 */
public class conf {
    
   
    public static String ip;
    public static String className;
    public static String BD;
    public static String user;
    public static String passw;
    public static String strconex;
    
    public static enum TypeBd {
        MySql,DerbyDb,SqlServer,MariaDb
    }
    
    

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        conf.ip = ip;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        conf.className = className;
    }

    public static String getBD() {
        return BD;
    }

    public static void setBD(String BD) {
        conf.BD = BD;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        conf.user = user;
    }

    public static String getPassw() {
        return passw;
    }

    public static void setPassw(String passw) {
        conf.passw = passw;
    }

    public static String getStrconex() {
        return strconex;
    }

    public static void setStrconex(String strconex) {
        conf.strconex = strconex;
    }
    
    public String toString(){
        
        return "Clase = "+ conf.className +" BD= "+ conf.BD +" IP= "+conf.ip +" passw= "+conf.passw +" con= "+conf.strconex +" user= "+conf.user;  
        
        
    }
    
    
    /** carga la configuracion del archivo de configuraciones
     * 
     *
     * @param TypeDb
     */
    
     public void  getConf(String TypeDb) {
        try {
           
            Properties propiedades = new Properties();

    
            switch(TypeDb.toUpperCase()){
                   case  "MYSQL":
                        propiedades.load(this.getClass().getResourceAsStream("mysql"));
                    break;
                 case "DERBY":
                 default:
                     propiedades.load(this.getClass().getResourceAsStream("derby"));
                    break; 

            }
                
            if (!propiedades.isEmpty()) {
                conf.ip = propiedades.getProperty("Ip");
             
                conf.className = propiedades.getProperty("ClassName");
              
                conf.BD = propiedades.getProperty("BD");
        
                conf.user = propiedades.getProperty("Usuario");
              
                conf.passw = propiedades.getProperty("Pass");
               
                conf.strconex = propiedades.getProperty("Conexion");
            
               System.out.println(" Contenido de las variable " + this.toString());
               
            } else {
             
                 System.out.println("Error al intentar obtener la configuración");
            }
        } catch (IOException ex) {
            System.out.println("Error al intentar leer el archivo de configuración");
           
        }
    }
    
    
//    public static void crearFile(String typeBd ) {
//        String texto ="";
//        switch(typeBd){
//            case  "MySql":
//                texto="# Configuracion MySQL\n"
//                + "Ip='//localhost:3306' \n"
//                + "Usuario= 'root' \n"
//                + "Pass='636358089' \n"
//                + "ClassName= 'com.mysql.jdbc.Driver' \n"
//                + "Conexion ='jdbc:mysql:' \n"
//                + "BD=/JUEZ";
//                 System.out.println("mysql text");
//                break;
//            case "DerbyDb":
//                texto="# Configuracion Derby\n"
//                + "Ip='//localhost:1527' \n"
//                + "Usuario= 'juez' \n"
//                + "Pass='zeuj' \n"
//                + "ClassName= 'org.apache.derby.jdbc.ClientDriver' \n"
//                + "Conexion ='jdbc:derby:' \n"
//                + "BD=/PROCEDIMIENTOS";
//                System.out.println("derby text");
//                break;
//            default:
//               texto="# Configuracion Derby \n"
//                + "Ip='//localhost:1527' \n"
//                + "Usuario= 'juez' \n"
//                + "Pass='zeuj' \n"
//                + "ClassName= 'org.apache.derby.jdbc.ClientDriver' \n"
//                + "Conexion ='jdbc:derby:' \n"
//                + "BD=/PROCEDIMIENTOS";
//                break;
//        }             
//        
//        System.out.println("Esto de guardae en la configuracion =[" +texto  +"]EOF");
//        FileWriter fichero = null;
//
//        PrintWriter pw = null;
//        try {
//            fichero = new FileWriter("./dist/conf");
//            pw = new PrintWriter(fichero);
//
//            pw.println(texto);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // Nuevamente aprovechamos el finally para
//                // asegurarnos que se cierra el fichero.
//                if (null != fichero) {
//                    fichero.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//    }
//    
    
}
