/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.clases;

//import modelo.CMetodo.getTipoVariable;
import modelo.tablas.Columna;
import modelo.tablas.Tabla;

/**
 *
 * @author zeus
 */
public class ClaseModelo {

    private Tabla tabla;
//    private String licencia;
//    private String autor;

    public ClaseModelo(Tabla tabla) {
        this.tabla = tabla;
        
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public String getEncabezado() {

        return "/** Esta clase se ha generado automaticamente \n"
                + "puede y contendra errores subsanables **/\n";
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
        String s = "package modelo;\n\n";
//        s += "import java.sql.SQLException;\n";
//        s += "import DataTable.JDataTable;\n";
//        s += "import DAO.DAO;\n";

        return s;
    }

    public String getInicioClase() {
        return "public class " + tabla.getNombreTablaToOneUpper() + "{\n";
    }

    public String getVariables() {
        String s = "";
        for (Columna col : tabla.getColumnas()) {

            s += col.getStringTipo_Nombre() + ";\n";

        }
        return s;

    }

    public String getConstructor() {
        return tabla.getConstructor() + tabla.getConstructorvacio();

    }

    public String getPropiedades() {
        String s = "";
        for (Columna col : tabla.getColumnas()) {

            s += col.getPropiedadGenerica();

        }
        return s;
    }

    public String getFinClase() {
        return "}//fin clase\n";
    }

}
