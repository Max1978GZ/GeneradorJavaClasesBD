/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataTable.JDataColumn;
import DataTable.JDataTable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tablas.Columna;
import modelo.tablas.Tabla;
import modelo.tablas.TipoClave;

/**
 *
 * @author zeus
 */
public class DAO {

    private Connection con = null;
    public ServerSql svr;

    public DAO() throws ClassNotFoundException {
        //public ServerSql(String ip, String puerto, String driver, String usuario, String password, String basedatos)
        svr = new ServerSql("localhost","1527","org.apache.derby.jdbc.ClientDriver","user","passw","bdatos");
        Class.forName(svr.getDriver());
    }
    public DAO(String cadenaConexion) throws ClassNotFoundException {
        //public ServerSql(String ip, String puerto, String driver, String usuario, String password, String basedatos)
        svr = new ServerSql("localhost","1527","org.apache.derby.jdbc.ClientDriver","user","passw","bdatos");
        Class.forName(svr.getDriver());
    }
    public DAO(String str_class, String str_driver, String user, String passw) throws ClassNotFoundException {
        svr = new ServerSql("localhost","1527",str_driver,user,passw,"bdatos");        
        Class.forName(svr.getDriver());
    }

    public DAO(String str_driver, String user, String passw) throws ClassNotFoundException {
          svr = new ServerSql("localhost","1527",str_driver,user,passw,"bdatos");
          Class.forName(svr.getDriver());

    }

    /**
     * Activa la conexion a la BD si no esta conectada
     *
     * @throws SQLException
     */
    private void conectar() throws SQLException {

        if (con == null || con.isClosed()) {
            if (svr.getDriver().isEmpty()) {
                
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "", "");
            
            } else {
                System.out.println("Activamos " +svr.getCadenaConexion());
                con = DriverManager.getConnection(svr.getCadenaConexion(),svr.getUsuario(),svr.getPassword());
             
            }
        }

    }

    /**
     * Retorna la tabla de la Consulta SELECT del SQL
     *
     * @param selectSQL
     * @return JDataTable
     * @throws SQLException
     * @throws Exception
     */
    public JDataTable getSelectInto(String selectSQL) throws SQLException, Exception {
        ResultSet rs;
        this.conectar();
        Statement stm = con.createStatement();

        rs = stm.executeQuery(selectSQL);

        JDataTable ta = new JDataTable(rs);
        if (!con.isClosed()) {
            con.close();
        }
        return ta;
    }

    /**
     * Retorna un array con las Tablas de la Base de datos
     *
     * @return
     * @throws Exception
     */
    public ArrayList<String> getTablesFromDB() throws Exception {
        ArrayList<String> ta = new ArrayList();
        this.conectar();

        DatabaseMetaData dbm = con.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = dbm.getTables(null, null, "%", types);

//        // asi sacamos usuarios TABLE_SCHEM
//        rs= dbm.getSchemas();
//        while (rs.next()) {
//            System.out.println(rs.getString("TABLE_SCHEM") +"...."+ rs.getString("TABLE_CATALOG") );
//        }
//         
        while (rs.next()) {
            ta.add(rs.getString("TABLE_NAME"));

        }

        if (!con.isClosed()) {
            con.close();
        }
        return ta;
    }

    /**
     * Retorna un array con las Tablas de la Base de datos
     *
     * @return
     * @throws Exception
     */
    public JDataTable getDataBaseFromDB() throws Exception {

        JDataTable ta;
        this.conectar();

        DatabaseMetaData dbm = con.getMetaData();

        ResultSet rs = dbm.getTables(null, null, null, null);
        ta = new JDataTable("sds");
        while (rs.next()) {
            System.out.println(rs.getString(1) + rs.getString(3));
        }

        rs = con.getMetaData().getSchemas();
        while (rs.next()) {
            System.out.println(rs.getString(1) + rs.getString(2));
        }

        if (!con.isClosed()) {
            con.close();
        }
        return ta;
    }

    /**
     * Retorna un Array con las Columnas de una tabla pasada por parametro
     *
     * @param tabla
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getColumnasFromTable(String tabla) throws SQLException {
        ArrayList<String> col = new ArrayList();
        ResultSet rs;
        this.conectar();
        Statement stm = con.createStatement();

        rs = stm.executeQuery("SELECT * FROM " + tabla);

        ResultSetMetaData rsMetaData = rs.getMetaData();

        int i = rsMetaData.getColumnCount();

        for (int a = 1; a <= i; a++) {
            col.add(rsMetaData.getColumnLabel(a) + " [" + rsMetaData.getColumnTypeName(a) + "](" + rsMetaData.getPrecision(a) + ")");
        }
        if (!con.isClosed()) {
            con.close();
        }

        return col;

    }

    /**
     * Retorna un Array con las Columnas de una tabla pasada por parametro
     *
     * @param tabla
     * @return
     * @throws SQLException
     */
    public JDataTable getSelectFromTableTiposColumnas(String tabla) throws SQLException, Exception {
        ArrayList<String> columna = new ArrayList();
        ArrayList<String> tipoColumna = new ArrayList();
        ResultSet rs;
        this.conectar();
        Statement stm = con.createStatement();
        rs = stm.executeQuery("SELECT * FROM " + tabla);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int i = rsMetaData.getColumnCount();
        for (int a = 1; a <= i; a++) {
            columna.add(rsMetaData.getColumnLabel(a));
            tipoColumna.add(rsMetaData.getColumnTypeName(a));
        }
        if (!con.isClosed()) {
            con.close();
        }

        JDataTable dt = new JDataTable(tabla);
        JDataColumn c = new JDataColumn("COLUMNA");
        c.setFilas(columna);
        JDataColumn t = new JDataColumn("TIPO");
        t.setFilas(tipoColumna);
        dt.addColumn(c);
        dt.addColumn(t);
        if (dt != null) {
            return dt;
        } else {
            return new JDataTable("vacio");

        }

    }

    /**
     * retorna un tabla con los datos
     *
     * @param tabla
     * @return
     * @throws SQLException
     */
    public JDataTable getColumnasTable(String tabla) throws SQLException {

        ArrayList<JDataColumn> columnas = new ArrayList();
        ResultSet rs;
        this.conectar();
        Statement stm = con.createStatement();

        rs = stm.executeQuery("SELECT * FROM " + tabla);

        ResultSetMetaData rsMetaData = rs.getMetaData();

        int i = rsMetaData.getColumnCount();

        for (int a = 1; a <= i; a++) {

            columnas.add(new JDataColumn(rsMetaData.getColumnLabel(a)));

        }

        while (rs.next()) {

            for (int d = 0; d < i; d++) {

                columnas.get(d).add(rs.getString(columnas.get(d).getNombre()));
            }

        }

        JDataTable ta = new JDataTable(tabla, columnas);

        if (!con.isClosed()) {
            con.close();
        }

        return ta;
    }

    public Tabla getTabla(String nombreTabla) throws SQLException {
        Tabla tabla = new Tabla();
        tabla.setNombreTabla(nombreTabla.toLowerCase());

//        ArrayList<String> colname = new ArrayList();
        ResultSet rs;
        this.conectar();
        Statement stm = con.createStatement();
        String sql = "SELECT * FROM " + nombreTabla;
        System.out.println(sql +"\n"+ this.con.getWarnings() );
        rs = stm.executeQuery(sql);

        ResultSetMetaData rsMetaData = rs.getMetaData();

        int i = rsMetaData.getColumnCount();

        for (int a = 1; a <= i; a++) {
            System.out.println(rsMetaData.getSchemaName(a));
            System.out.println(rsMetaData.getCatalogName(a));
            System.out.println(rsMetaData.getColumnClassName(a));
            System.out.println(rsMetaData.getColumnType(a));
            System.out.println(rsMetaData.getColumnTypeName(a));
            System.out.println(rsMetaData.getScale(a));
            System.out.println(rsMetaData.getColumnDisplaySize(a));

            ///Columna(String nombreCampo, String tipoCampo, int longituCampo, TipoClave tipoClave)
            String nombre = rsMetaData.getColumnLabel(a);
            String tipoDato = rsMetaData.getColumnClassName(a);
            Integer longdato = rsMetaData.getPrecision(a);
            String primarykey = String.valueOf(rsMetaData.getColumnType(a));
            Columna col = null;
            if (a == 1) {
                col = new Columna(nombre.toLowerCase(), tipoDato.replaceFirst("java.lang.", ""), longdato, TipoClave.PRIMARY_KEY);
            } else {
                col = new Columna(nombre.toLowerCase(), tipoDato.replaceFirst("java.lang.", ""), longdato, TipoClave.INDEFINED);
            }
            System.out.println(col.toString());
            tabla.getColumnas().add(col);

        }
        if (!con.isClosed()) {
            con.close();

        //return col; 
           
        }
        return tabla;
    }
}