/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.clases;

import modelo.tablas.Tabla;

/**
 *
 * @author zeus
 */
public class ClaseModeloDao {

    Tabla tabla;

    public static final char comilla = 34;

    public ClaseModeloDao(Tabla tabla) {
        this.tabla = tabla;
    }

    public String getEncabezado() {

        return "/* Esta clase se ha generado automaticamente \n"
                + "puede y contendra errores subsanables */\n";
    }

    public String getLicencia() {
        return "/*\n"
                + " This program is free software: you can redistribute it and/or modify\n"
                + " it under the terms of the GNU General Public License as published by\n"
                + " the Free Software Foundation, either version 3 of the License, or\n"
                + " (at your option) any later version.\n"
                + "\n"
                + " This program is distributed in the hope that it will be useful,\n"
                + " but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
                + " MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"
                + " GNU General Public License for more details.\n"
                + "\n"
                + " You should have received a copy of the GNU General Public License\n"
                + " along with this program.  If not, see <http://www.gnu.org/licenses/>.\n"
                + "\n"
                + " */\n";
    }

    public String getAutor(String autor,String email) {
        return "/** Autor: " + autor +"\n" +" @mail:" + email+"**/ \n";
    }

    public String getImports() {
        String s = "package Dao;\n\n";
        s += "import java.sql.SQLException;\n";
        s += "import DataTable.JDataTable;\n";
        s += "import Dao.Dao;\n";

        return s;
    }

    public String getInicioClase() {
        return "public class Dao" + tabla.getNombreTablaToOneUpper() + "{\n";
    }

    public String metodoSelect() {
        String s = "";

        s += "public static JDataTable cargarBD() throws ClassNotFoundException, Exception{\n";
        s += "dao= new DAO();\n";
        s += "return  dao.getSelectInto(" + this.comilla + "SELECT * FROM " + tabla.getNombreTabla().toUpperCase() + this.comilla + ");\n";
        s += "}\n";
        s += "public static JDataTable cargarBD(String sql) throws ClassNotFoundException, Exception{\n";
        s += "dao= new DAO();\n";
        s += "return  dao.getSelectInto(sql);\n";
        s += "}\n";

        return s;
    }

//    public static String metodoInsertInto(String tabla, ArrayList<String> column) {
//        String s = "";
//
//        s += "public int add() throws ClassNotFoundException, SQLException{\n";
//        s += "dao= new DAO();\n";
//        //INSERT INTO NOMBRETABLA[ campos de las tabla] VALUES (valores de los campos de la tabl
//        s += "String sql = " + modelo.BDClass.comilla + "INSERT INTO " + tabla.toUpperCase();
//        s += " (";
//        for (String col : column) {
//            s += col +",";
//        }
//        s = s.substring(0, s.length() - 1);
//        s += ") VALUES(" + modelo.BDClass.comilla ;
//
//        for (String col : column) {
//            s +="+"+ "this.get" + modelo.CMetodo.toOneUpper(col.toLowerCase())+"()"+ "+" +  modelo.BDClass.comilla + ","+ modelo.BDClass.comilla ;
//        }
//        s = s.substring(0, s.length() - 2);
//        s += ")"+modelo.BDClass.comilla+";\n";
//        s += "return dao.insertar(sql);\n";
//        s += "}\n";
//        return s;
//    }
//////    public static String metodoUpdate(String tabla, String column[]){
//////          String s = "";
//////        s += "public static int update(String sql) throws ClassNotFoundException, SQLException{\n";
//////        s += "dao= new DAO();\n";
//////        
//////        s+="String sql ="+ modelo.BDClass.comilla + "UPDATE " + modelo.BDClass.comilla + tabla.toUpperCase() + modelo.BDClass.comilla +  "SET ";
////////        for(int i=0;i<column.
////////                
////////                s+=        
////////                
////////                + "CLIENTE='" + this.getcliente()
////////                + "',NUMCARPETA='" + this.getnumcarpeta()
////////                + "',DNI='" + this.getdni()
////////                + "',DIRECCION='" + this.getdireccion()
////////                + "',TELEFONO='" + this.gettelefono()
////////                + "',MOVIL='" + this.getmovil()
////////                + "',INFO='" + this.getinfo()
////////                + "' WHERE IDCLIENTE=" + this.getidcliente();
//////
//////    //    return dao.modificar(sql);
//////
//////  //  }
//////        
//////        
//////        
//////        
////////        
////////        s += "return dao.eliminar(" + modelo.BDClass.comilla + "DELETE FROM " + tabla.toUpperCase() + " WHERE ID"+tabla.substring(0, tabla.length()-1) +"="+modelo.BDClass.comilla+ "+clave" + ");\n";
////////        s += "}\n";
//////        return s;
//////
//////    }
//////    
    public String metodoDelete() {
        String s = "";
        s += "public static int delete(String clave) throws ClassNotFoundException, SQLException{\n";
        s += "dao= new DAO();\n";
        s += "return dao.eliminar(" + this.comilla + "DELETE FROM " + tabla.getNombreTabla().toUpperCase() + " WHERE " + tabla.getColumnaPrimaryKey().getNombreCampoToUpper() + "=" + this.comilla + "+clave" + ");\n";
        s += "}\n";
        return s;

    }

    public String getFinClase() {
        return "}//fin clase";
    }

}
