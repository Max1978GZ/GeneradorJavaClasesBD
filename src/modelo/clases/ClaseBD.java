 /*
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package modelo.clases;

/**
 * Febrero del 2014
 *
 * @author Máximo Coejo Cores mcoejo@gmail.com
 */
public class ClaseBD {

    public static final char comilla = 34;
    
    public static String getEncabezado() {

        return "/** Esta clase se ha generado automaticamente \n"
                + "puede y contendra errores subsanables **/\n";
    }

    public static String getLicencia() {
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

    public static String getAutor(String autor,String email) {
        return "/** Autor: " + autor +"\n" +" @mail:" + email+"**/ \n";
    }
    
    

    public static String importPackages() {
        String s = "";
        s += "package DAO;\n";
        s += "import DataTable.JDataTable;\n";
        s += "import java.sql.Connection;\n";
        s += "import java.sql.DatabaseMetaData;\n";
        s += "import java.sql.DriverManager;\n";
        s += "import java.sql.ResultSet;\n";
        s += "import java.sql.SQLException;\n";
        s += "import java.sql.Statement;\n";
        s += "import java.util.ArrayList;\n";
        return s;
    }

 
    
    
    public static String getConectarClase(String BD, String user,String passw) {
        String s = "";
        s += " public class DAO {\n";
        s += "Connection con=null; \n";
        s += "public DAO() throws ClassNotFoundException {\n";
        s += "Class.forName(" + comilla + "org.apache.derby.jdbc.ClientDriver" + comilla + ");\n";
        s += "} \n";

        s += "/**\n";
        s += "* Constructor expecifico, se le pasa el driver por parametro\n";
        s += "* @param SQLClientDriver\n";
        s += "* @throws ClassNotFoundException \n";
        s += "*/\n";
        s += "public DAO(String SQLClientDriver) throws ClassNotFoundException {\n";
        s += "      Class.forName(SQLClientDriver); \n";

        s += "}\n";

        s += "/**\n";
        s += "* Activa la conexion a la BD si no esta conectada\n";
        s += "* @throws SQLException\n";
        s += "*/\n";
        s += "private void conectar() throws SQLException{\n";
        s += "if(con == null || con.isClosed())\n";
        s += "{\n";
        s += "    con = DriverManager.getConnection(" + comilla + "jdbc:derby://localhost:1527/"+BD + comilla + "," + comilla + user + comilla + "," + comilla + passw + comilla + ");\n";
        s += "}\n";
        s += "}\n";

        s += "/**\n";
        s += "* Activa la conexion a la BD si no esta conectada\n";
        s += "* @throws SQLException \n";
        s += "*/\n";
        s += "private void conectar(String stringConect,String user,String password) throws SQLException{\n";
        s += "if(con == null || con.isClosed())\n";
        s += " {\n";
        s += "    con = DriverManager.getConnection(stringConect,user,password);\n";
        s += " } \n";
        s += "} \n";

        return s;
    }

    public static String metodoInsertInto() {
        String s = "";
        s += "/**\n";
        s += "* Ejecuta la String SQL en el servidor BD\n";
        s += "* @param SQL\n";
        s += "* @return numero de filas modificadas\n";
        s += "* @throws SQLException \n";
        s += "*/\n";
        s += "public int insertar(String SQL) throws SQLException{\n";
        s += "int registro = 0;\n";
        s += "this.conectar();\n";
        s += "Statement stm = con.createStatement();\n";
        s += "registro = stm.executeUpdate(SQL);\n";
        s += "System.out.println(SQL);\n";
        s += "if ( registro >0){\n";
        s += "   System.out.println(" + comilla + "ok" + comilla + " + registro);\n";
        s += "}\n";
        s += "con.close();\n";
        s += " return registro;\n";
        s += "}\n";
        return s;

    }

    public static String metodoDelete() {
        String s = "";
        s += "/**\n";
        s += "* Ejecuta la String SQL en el servidor BD\n";
        s += "* @param SQL\n";
        s += "* @return numero de filas afectadas\n";
        s += "* @throws SQLException \n";
        s += "*/\n";
        s += "public int eliminar(String SQL) throws SQLException{\n";
        s += "int registro = 0; \n";
        s += "this.conectar();\n";
        s += "Statement stm = con.createStatement();\n";
        s += "registro = stm.executeUpdate(SQL);\n";
        s += "System.out.println(SQL);\n";
        s += "if ( registro >0){\n";
        s += "   System.out.println(" + comilla + "ok " + comilla + "+registro);\n";
        s += "}\n";
        s += "con.close();\n";
        s += "return registro;\n";
        s += "}\n";
        return s;
    }

    public static String metodoSelect() {
        String s = "";
        s += "/**\n";
        s += "* Retorna la tabla de la Consulta SELECT del SQL\n";
        s += "* @param selectSQL\n";
        s += "* @return JDataTable\n";
        s += "* @throws SQLException\n";
        s += "* @throws Exception \n";
        s += "*/\n";
        s += "public JDataTable getSelect(String selectSQL) throws SQLException, Exception{ \n";
        s += "ResultSet rs;\n";
        s += "this.conectar();\n";
        s += "Statement stm = con.createStatement();\n";
        s += "rs = stm.executeQuery(selectSQL);\n";
        s += "JDataTable ta = new JDataTable(rs);\n";
        s += "if (!con.isClosed())\n";
        s += "  con.close();\n";
        s += "return ta;\n";
        s += "}\n";

        return s;
    }

//    public static String metodoSelect2() {
//        String s = "";
//        s += "/**\n";
//        s += "* Retorna la tabla de la Consulta SELECT del SQL\n";
//        s += "* @param selectSQL\n";
//        s += "* @return JDataTable\n";
//        s += "* @throws SQLException\n";
//        s += "* @throws Exception \n";
//        s += "*/\n";
//        s += "public  ArrayList<Object> getSelectInto(String SQL) throws SQLException, Exception{ \n";
//
//        s += "ResultSet rs;\n";
//        s += "ArrayList<Object> objectos = new ArrayList <Object>();\n";
//        s += "this.conectar();\n";
//        s += "Statement stm = con.createStatement();\n";
//        s += "rs = stm.executeQuery(SQL);\n";
//        s += "System.out.println(SQL);\n";
//
//        s += "while(rs.next()){\n";
//
//        s += "//Object a;\n";
//        s += "//a= new Object( rs.getString(" + comilla + "CAMPO1" + comilla + "),\n";
//        s += "//        rs.getString(" + comilla + "CAMPO2" + comilla + "),\n";
//        s += "//        rs.getString(" + comilla + "CAMPO3" + comilla + "),\n";
//        s += "//        Double.valueOf(rs.getString(" + comilla + "CAMPO4" + comilla + ")),\n";
//        s += "//        Integer.valueOf(rs.getString(" + comilla + "CAMPO5" + comilla + ")));\n";
//        s += "//a.setCurso(rs.getString(" + comilla + "CAMPO6" + comilla + "));\n";
//        s += "//objectos.add(a);\n";
//
//        s += "}\n";
//        s += "if (!con.isClosed())\n";
//        s += "  con.close();\n";
//        s += "return objectos;\n";
//        s += "}\n";
//
//        return s;
//    }

    public static String metodoUpdate() {
        String s = "";
        s += "/**\n";
        s += "* Ejecuta la String SQL en el Servidor BD\n";
        s += "* @param SQL\n";
        s += "* @return numero de filas modificadas\n";
        s += "* @throws SQLException \n";
        s += "*/\n";
        s += "public int modificar(String SQL) throws SQLException{\n";

        s += "int registro = 0;\n";
        s += "this.conectar();\n";
        s += "Statement stm = con.createStatement();\n";
        s += "registro = stm.executeUpdate(SQL);\n";
        s += "System.out.println(SQL);\n";
        s += "if ( registro >0){\n";
        s += "   System.out.println(" + comilla + "ok " + comilla + "+registro);\n";
        s += "}\n";
        s += "con.close();\n";
        s += "return registro;\n";
        s += "}\n";
        return s;
    }

    public static String metodoCount() {
        String s;
        s = "/**\n";
        s += " * Retorna un solo valor entero util para consulta de conteo de filas\n";
        s += "*\n";
        s += "* @param selectSQL\n";
        s += "* @return Integer\n";
        s += "* @throws SQLException\n";
        s += "* @throws Exception\n";
        s += "*/\n";
        s += "public Integer getCount(String selectSQL) throws SQLException, Exception {\n";
        s += "ResultSet rs;\n";
        s += "Integer valor =0;\n";
        s += "this.conectar();\n";
        s += "Statement stm = con.createStatement();\n";
        s += " rs = stm.executeQuery(selectSQL);\n";
        s += "if(rs.next()){\n";
        s += "     valor = Integer.valueOf(rs.getString(1));\n";

        s += "}\n";

        s += " if (!con.isClosed()) {\n";
        s += "     con.close();\n";
        s += " }\n";
        s += " return valor;\n";
        s += " }\n";

        return s;
    }
        
    public static String getFinClase(){
        return "}// fin clase";
        
    }

}
