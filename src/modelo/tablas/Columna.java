/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tablas;

/**
 *
 * @author zeus
 */
public class Columna {

    private String nombrecampo;
    private String tipocampo;
    private int longitudcampo;
    private TipoClave tipoclave;

    public Columna(String nombreCampo, String tipoCampo, int longituCampo, TipoClave tipoClave) {
        this.nombrecampo = nombreCampo;
        this.tipocampo = tipoCampo;
        this.longitudcampo = longituCampo;
        this.tipoclave = tipoClave;
    }

    public Columna() {

    }

    public String getNombreCampoOneUpper() {
        String caracter = this.nombrecampo.substring(0, 1);
        caracter = caracter.toUpperCase();
        caracter = caracter + this.nombrecampo.substring(1, this.nombrecampo.length());
        return caracter;
    }

    public String getNombreCampoToUpper() {

        return this.nombrecampo.toUpperCase();
    }

    public String getNombreCampo() {
        return nombrecampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombrecampo = nombreCampo;
    }

    public String getTipoCampo() {
        return tipocampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipocampo = tipoCampo;
    }

    public int getLongitudCampo() {
        return longitudcampo;
    }

    public void setLongitudCampo(int longituCampo) {
        this.longitudcampo = longituCampo;
    }

    public TipoClave getTipoclave() {
        return tipoclave;
    }

    public void setTipoclave(TipoClave tipoclave) {
        this.tipoclave = tipoclave;
    }

    @Override
    public String toString() {
        return "Columna{" + "nombrecampo=" + nombrecampo + ", tipocampo=" + tipocampo + ", longitudcampo=" + longitudcampo + ", tipoclave=" + tipoclave + '}';
    }
    
    
    
    
    public String getStringTipo_Nombre(){
        return this.tipocampo +" " +this.nombrecampo ;
    }
    
    public String getnombreIgualMetodoParaUpdate(){
        if(this.tipocampo.toUpperCase().contains("CHAR")||this.tipocampo.toUpperCase().contains("VAR")){
            return this.getNombreCampo() +"='" +this.getNombreCampoOneUpper()+"()'," ;
        }
        return this.getNombreCampo() +"=" +this.getNombreCampoOneUpper()+"()," ;
    }
    
    
//    public String ObtenerMetodosGetSet(){
//       
//        
//         switch (this.tipocampo) {
//            case "INTEGER":                
//                return getPropiedadGenerica("Integer");
//            case "REAL":
//                return getPropiedadGenerica("Long");
//            case "NUMERIC":
//                return getPropiedadGenerica("Integer");
//            case "VARCHAR":
//                return getPropiedadGenerica("String");
//            case "LONG VARCHAR":
//                return getPropiedadGenerica("String");
//            case "TIME":
//                return getPropiedadGenerica("Date");
//            case "DATE":
//                return getPropiedadGenerica("Date");
//            case "BOOLEAN":
//                return getPropiedadGenerica("Boolean");
//            case "DECIMAL":
//                return getPropiedadGenerica("Double");
//            case "SMALL INT":
//                return getPropiedadGenerica("Integer");
//            case "BIG INT":
//                return getPropiedadGenerica("Long");
//            case "DOUBLE":
//                return getPropiedadGenerica("Double");
//            case "CHAR":
//                return getPropiedadGenerica("Character");
//            case "SMALLINT":
//                return getPropiedadGenerica("Integer");
//            case "BIGINT":
//                return getPropiedadGenerica("Long");
//            default:
//                return getPropiedadGenerica("Object");
//        
//        
//         }
        
        
        
        
//    }
    
     public String getPropiedadGenerica() {

        String s="";
      
        s += "public "+this.tipocampo+" get" + this.getNombreCampoOneUpper() + "(){\n\n";
        s += "return " + this.getNombreCampo() + ";\n\n";
        s += "}\n\n";

        s += "public void set" +this.getNombreCampoOneUpper() + "("+this.tipocampo+" " + this.getNombreCampo() + "){\n\n";
        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
        s += "}\n\n\n";
        return s;
    }
    
    /**************************** GET Y SET ************************************/
//     public String getStringPropiedad() {
//
//        String s="";
//      
//        s += "public String get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(String " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorna un String con los get y set de una variable contenida en nombre
//     * de tipo Integer
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getIntegerPropiedad(String nombre) {
//
//       String s="";
//      
//        s += "public Integer get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(Integer " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorna un String con los get y set de una variable contenida en nombre
//     * de tipo Double
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getDoublePropiedad() {
//
//        String s="";
//      
//        s += "public Double get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(Double " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorna un String con los get y set de una variable contenida en nombre
//     * de tipo Boolean
//     *
//     * @param nombre
//     * @return
//     */
//    public String getBooleanPropiedad() {
//
//        String s="";
//      
//        s += "public Boolean get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(Boolean " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorna un String con los get y set de una variable contenida en nombre
//     * de tipo Boolean
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getDatePropiedad() {
//
//        String s="";
//      
//        s += "public Date get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(Date " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorna un String con los get y set de una variable contenida en nombre
//     * de tipo char
//     *
//     * @param nombre
//     * @return
//     */
//    public String getCharacterPropiedad() {
//
//       String s="";
//      
//        s += "public Character get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(Character " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorna un String con los get y set de una variable contenida en nombre
//     * de tipo real
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getRealPropiedad() {
//
//        String s="";
//      
//        s += "public Long get" + this.getNombreCampoOneUpper() + "(){\n\n";
//        s += "return " + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n";
//
//        s += "public void set" +this.getNombreCampoOneUpper() + "(Long " + this.getNombreCampo() + "){\n\n";
//        s += "this." + this.getNombreCampo() + "=" + this.getNombreCampo() + ";\n\n";
//        s += "}\n\n\n";
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un integer
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getInteger() {
//        String s;
//
//        s = "private Integer " + this.getNombreCampo() + ";\n\n";
//
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un String
//     *
//     * @param nombre
//     * @return
//     */
//    public String getString() {
//        String s;
//
//        s = "private String " + this.getNombreCampo() + ";\n\n";
//
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un Double
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getDouble() {
//        String s;
//
//        s = "private Double " +this.getNombreCampo() + ";\n\n";
//
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un boolean
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getBoolean() {
//        String s;
//
//        s = "private Boolean " +this.getNombreCampo() + ";\n\n";
//
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un Date
//     *
//     * @param nombre
//     * @return
//     */
//    public String getDate() {
//        String s;
//
//        s = "private Date " + this.getNombreCampo()+ ";\n\n";
//
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un Date
//     *
//     * @param nombre
//     * @return
//     */
//    public  String getCharacter() {
//        String s;
//
//        s = "private Character " + this.getNombreCampo() + ";\n\n";
//
//        return s;
//    }
//
//    /**
//     * Retorn la cadena de declaracion de un Real
//     *
//     * @param nombre
//     * @return
//     */
//    public String getReal() {
//        String s;
//
//        s = "private Integer " + this.getNombreCampo() + ";\n\n";
//
//        return s;
//    }
//    
//    
//    
//    
//    
//    
//    
//    
}
