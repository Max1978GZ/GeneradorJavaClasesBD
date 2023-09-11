/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package modelo.db;
////
////import java.sql.ResultSet;
////import java.sql.ResultSetMetaData;
////import java.sql.SQLException;
////import java.util.ArrayList;
////
/////**
//// *
//// * @author zeus
//// */
////public class JDataTabla {
////    private String nombre;
////    private ArrayList<JDataColumn> Columnas;
/////********************* CONSTRUCTORES **********************************   */
////    /**
////     * Crea una tabla con dos arraylist que guardan las columnas y el tipo de dato
////     * @param Columnas 
////     */
////    public JDataTabla(String nombreTabla, ArrayList<JDataColumn> Columnas) {
////        this.nombre = nombreTabla;
////        this.Columnas = Columnas;
////     }  
////
////    /**
////     * Crea una tabla segun sea el ResultSet pasado como parametro
////     * @param rs
////     * @throws SQLException 
////     */
////    public JDataTabla(ResultSet rs) throws SQLException{
////       Columnas = new ArrayList<JDataColumn>();
////       ResultSetMetaData rsMetaData = rs.getMetaData();
////       int i = rsMetaData.getColumnCount();
////       for(int a=1;a<=i;a++){
////            Columnas.add(new JDataColumn(rsMetaData.getColumnLabel(a)));       
////        }
////       while(rs.next()){
////         for (int d=0;d<i;d++){
////             Columnas.get(d).add(rs.getString(Columnas.get(d).getNombre()));
////           }  
////        }   
////    }
////   
////    /**
////     * Crea una tabla vacia 
////     * @param nombre 
////     */
////    public JDataTabla(String nombre) {
////        this.nombre = nombre;
////        this.Columnas= new ArrayList<JDataColumn>();       
////    }
/////******************************************************************************/   
////    /**
////     * Inserta una columna en la tabla y ajusta todas las filas de todas las columnas
////     * @param nombreColumna
////     * @param tipo 
////     */
////    public void addColumn(JDataColumn col){
////        if(this.Columnas.size()>0){
////            int i =this.Columnas.get(0).lenth();
////            int j =col.lenth();
////            if (i-j>0){
////                for(int a=0; a<i-j; a++){
////                     col.add("");
////                }
////            }else if(i-j<0){
////                for(int a=0;a<this.Columnas.size();a++){
////                    this.Columnas.get(a).insertFilesNull(j-i,"");                
////                }
////            }
////        }
////        this.Columnas.add(col);
////    }
////    /**
////     * Elimina una Columna de la tabla si existe
////     * @param nameColumn 
////     */
////    public void delColumn(String nameColumn){
////        int a= this.findColumn(nameColumn);
////        if (a>-1){
////            this.Columnas.remove(a);            
////        }     
////        
////    }
////    /**
////     * Retorna la posisicon de la primera coincidencia del nombre del JDataColumn con el parametro name
////     * En caso de que no exista retorna -1
////     * @param name
////     * @return int
////     */
////    public int findColumn(String name){
////        
////        for (int i =0; i <this.Columnas.size();i++){
////            if(name.equalsIgnoreCase(this.Columnas.get(i).getNombre()))
////                return i;
////            
////        }
////        return -1;        
////    }
////    
////    
////    
////    
////    /**
////     * Devuelve el numero de columnas del Array
////     * @return  integer
////     */
////    public int getColumnLenth() {
////        return this.Columnas.size();
////    }
////   
////  /**
////     * Devuelve el numero de columnas del Array
////     * @return  integer
////     */
////    public int getRowsLenth() {
////        if(this.Columnas.size()>0){
////            return this.Columnas.get(0).lenth();
////        }  
////        
////        return 0;
////    }
////    
////    
////    public JDataColumn getColumn(int index){
////        
////       return this.Columnas.get(index);
////        
////    }
////    
////    
////    /**
////     * Retorna el nombre de la tabla
////     * @return 
////     */
////    public String getName() {
////        return nombre;
////    }
////    /**
////     * Asigna un nuevo nommbre a la tabla
////     * @param nombre 
////     */
////    public void setName(String nombre) {
////        this.nombre = nombre;
////    }
////    /**
////     * retona un arraylist con las columnas de la tabla 
////     * @return 
////     */
////    public ArrayList<JDataColumn> getColumns() {
////        return Columnas;
////    }
////    /**
////     * Muestra por consola la tabla almacenada 
////     */    
////    public void showTabla(){
////        // Imprimimos los nombres de las columnas
////        for(int i=0 ; i<this.Columnas.size();i++){
////           JDataColumn ca = (JDataColumn) this.Columnas.get(i);
////           System.out.print("        [" +ca.getNombre()+"]      ");          
////        }            
////        System.out.println();
////          
////        for(int a=0 ; a<this.Columnas.get(0).lenth();a++){//filas
////             for(int i=0 ; i<this.Columnas.size();i++){ //columnas
////                    JDataColumn c = (JDataColumn) this.Columnas.get(i);
////          
////                    
////                    System.out.print("    <"+c.getFilas().get(a) +">      ");                
////             }   
////           System.out.println();
////        }
////    }
////    /**
////     * Retorna un String con todos los datos de la tabla 
////     * @return 
////     */
////    public String showTablaToString(){
////        String s = "";
////        for(int i=0 ; i<this.Columnas.size();i++){
////           JDataColumn ca = (JDataColumn) this.Columnas.get(i);
////          s=s.concat("   [" +ca.getNombre()+"]  ");          
////        }            
////         s=s.concat("\n");
////          for(int a=0 ; a<this.Columnas.get(0).lenth();a++){
////            for(int i=0 ; i<this.Columnas.size();i++){
////       
////           JDataColumn c = (JDataColumn) this.Columnas.get(i);
////           s=s.concat("   <"+c.getFilas().get(a) +">  ");                
////        }   
////           s=s.concat("\n");
////        }
////        
////        return s;
////    }
////        
////}  
////    
    
    
    