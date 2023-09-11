/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas;

import modelo.tablas.Columna;
import java.util.ArrayList;
//import static modelo.CMetodo.getTipoVariable;
 
/**
 *
 * 
 * @author zeus
 */
public class Tabla {
    public static final char comilla = 34;
    private String nombretabla;
    private ArrayList<modelo.tablas.Columna> columnas;

    public Tabla(String nombretabla, ArrayList<Columna> columnas) {
        this.nombretabla = nombretabla;
        this.columnas = columnas;
    }

    public Tabla() {
        this.columnas = new ArrayList();
    }
    
    
    public String getNombreTablaToOneUpper() {
         String caracter = this.nombretabla.substring(0,1);
         caracter = caracter.toUpperCase();
         caracter = caracter + this.nombretabla.substring(1,this.nombretabla.length());         
        return caracter;
    }

    public String getNombreTabla() {
        return nombretabla;
    }
    public String getNombreTablaToUpper() {
        return nombretabla.toUpperCase();
    }


    public void setNombreTabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    public ArrayList<Columna> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<Columna> columnas) {
        this.columnas = columnas;
    }
    
    public Columna getColumnaPrimaryKey(){
        
        for(Columna col: this.columnas){
            
            if(col.getTipoclave()==TipoClave.PRIMARY_KEY){
                return col;
            }
        }
        
        return null;
        
    }
    
    /***************************** CONSTRUCTOR   *******************************/
    /**
     * 
     * @return 
     */
    public String getConstructor() {
        String s = "";

        s += "public " + this.getNombreTablaToOneUpper() + "(";
        for (int i = 0; i < this.columnas.size(); i++) {
            s += this.columnas.get(i).getStringTipo_Nombre();
            if (i != columnas.size() - 1) {
                s += ",";
            }
        }
        s += "){\n\n";

        for (int i = 0; i < columnas.size(); i++) {
            s += "this." + columnas.get(i).getNombreCampo() + "=" + columnas.get(i).getNombreCampo();

            s += ";\n";
        }
        s += "}\n\n";

        return s;
    }
    
    
     public String getConstructorvacio() {
        String s = "";

        s += "public " + this.getNombreTablaToOneUpper() + "(";
//        for (int i = 0; i < this.columnas.size(); i++) {
//            s += this.columnas.get(i).getStringTipo_Nombre();
//            if (i != columnas.size() - 1) {
//                s += ",";
//            }
//        }
        s += "){\n\n";

//        for (int i = 0; i < columnas.size(); i++) {
//            s += "this." + columnas.get(i).getNombreCampo() + "=" + columnas.get(i).getNombreCampo();
//
//            s += ";\n";
//        }
        s += "}\n\n";

        return s;
    }
    
    
    /****************** INSERT INTO ***************************************/
     public String getMetodoInsertInto() {
        String s = "";

        s += "public int add() throws ClassNotFoundException, SQLException{\n";
        s += "dao= new DAO();\n";
        //INSERT INTO NOMBRETABLA[ campos de las tabla] VALUES (valores de los campos de la tabl
        s += "String sql = " +this.comilla + "INSERT INTO " + this.nombretabla;
        s += " (";
        for (Columna col : columnas) {
            s += col.getNombreCampoToUpper() +",";
        }
        // quitamos la ultima coma
        s = s.substring(0, s.length() - 1);
        s += ") VALUES(" + this.comilla ;

        for (Columna col : columnas) {
            s +="+"+ "this.get" + col.getNombreCampoOneUpper()+"()"+ "+" +  this.comilla + ","+ this.comilla ;
        }
        s = s.substring(0, s.length() - 2);
        s += ")"+this.comilla+";\n";
        s += "return dao.insertar(sql);\n";
        s += "}\n";
        return s;
        
    }
     
       public  String getMetodoUpdate(){
          String s = "";
        s += "public static int update(String sql) throws ClassNotFoundException, SQLException{\n";
        s += "dao= new DAO();\n";
        
        s+="String sql ="+ this.comilla 
         + "UPDATE " + this.comilla 
         + this.getNombreTablaToUpper() 
         + this.comilla +  "SET ";
        for(int i=0;i<columnas.size();i++){
                s+=columnas.get(i).getnombreIgualMetodoParaUpdate();
        }        
                s+= " WHERE IDCLIENTE= "+ this.comilla+" get" + this.getColumnaPrimaryKey().getNombreCampo();

        s+="return dao.modificar(sql);";

    
    
    return s;
       }
    
    
    
    
    
    
    
    
    
    
}
