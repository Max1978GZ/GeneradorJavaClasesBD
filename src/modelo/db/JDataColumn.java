///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package modelo.db;
//
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
///**
// *
// * @author zeus
// */
//public class JDataColumn {
//    private modelo.db.JDataTabla Tabla;
//    private String nombre;
//    //private ArrayList<java.db.JDataRow> filas;
//    private ArrayList<String> cadenas;
//    
//    /**************** constructores *****************************/
//    /**
//     * Constructor de un array vacio llamado por el contenido en nombre
//     * @param nombre 
//     */
//    public JDataColumn(String nombre) {
//        this.nombre = nombre;
//        //filas = new ArrayList<java.db.JDataRow>();
//        cadenas =  new ArrayList<String>();
//    }
//    /**
//     * Crea un JDataColumn vacio y lo relaciona con una tabla
//     * @param nombre
//     * @param tabla 
//     */
//    public JDataColumn(String nombre,modelo.db.JDataTabla tabla) {
//        this.nombre = nombre;
//         cadenas= new ArrayList<String>();
//        //filas = new ArrayList<java.db.JDataRow>();
//        this.Tabla=tabla;
//    }
//
//    /***************** PROPIEDADES ***************************/
//    /**
//     * Retorna el nombre de la Columna
//     * @return 
//     */
//    public String getNombre() {
//        return nombre;
//    }
//    /**
//     * Asigna un nombre a la columna
//     * @param nombre 
//     */
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//    /**
//     * Retorna un array con todas las filas del JDataColumn
//     * @return 
//     */
//    public ArrayList<String> getFilas() {
//        return cadenas;
//    }
//    
//    
//    /**
//     * Retorna un array con todas las filas del DataColumn
//     * @return 
//     */
//    public String[] getFilasToArray() {
//      //  System.out.println(this.cadenas.size());
//        String s[]= new String[this.cadenas.size()];
//        for(int i =0;i<this.cadenas.size();i++){
//            s[i] = this.cadenas.get(i );
//          //  System.out.println(i);
//        }      
//        
//        
//        return s;
//    }
//    
//    /**
//     * Sobreescribe el array de filas del JDataColumn
//     * @param filas 
//     */
//    public void setFilas(ArrayList<String> filas) {
//        this.cadenas = filas;
//    }
//    
//    /***************** FIN PROPIEDADES **********************************/
//    /***************** METODOS *****************************************/
//    
//    /**
//     * Inserta el valor en el JDataColumn tantas veces como indique num
//     * Introduce en el array 
//     * @param num 
//     */
//    public void insertFilesNull(int num,String valor){
//        for (int i=0; i<num;i++){
//            this.cadenas.add(valor);
//        }
//    }
//    /**
//     * Añade un valor al array de String
//     * @param valor 
//     */
//    public void add(String valor){
//        this.cadenas.add(valor);
//    }
//    /**
//     * Retorna la cantidad de filas de la columna
//     * @return 
//     */
//    public int lenth(){
//        return this.cadenas.size();
//    }
//    
//    /**
//     * Retorna un String con el contenido del array en la posicion indicada por parametro
//     * @param index
//     * @return 
//     */
//    public String getRow(int index){
//        
//       return this.cadenas.get(index);
//        
//    }
//    /**
//     * Asigna un valor a la posicion del array indicada por parametro
//     * @param valor
//     * @param index 
//     */
//    public void SetRow(int index,String valor){
//        
//        this.cadenas.set(index, valor);
//        
//    }
//    /**
//     * Elimina la fila indicada por la posicion (index) del JDataColumn
//     * Retorna el contenido de la fila eliminada
//     * @param index
//     * @return 
//     */
//    public String deleteRow(int index){
//        return this.cadenas.remove(index);
//        
//    }
//    
//    
//}
