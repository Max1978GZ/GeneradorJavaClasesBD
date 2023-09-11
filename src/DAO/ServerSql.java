/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author zeus
 */
public class ServerSql {
    
   private String ip;
   private String puerto;
   private String driver;
   private String usuario;
   private String password;
   private String basedatos;
   private String tiposervidor;

    public ServerSql() {
    }
   
    public ServerSql(String ip, String puerto, String driver, String usuario, String password, String basedatos) {
        this.ip = ip;
        this.puerto = puerto;
        this.driver = driver;
        this.usuario = usuario;
        this.password = password;
        this.basedatos = basedatos;
    }

    public ServerSql(String ip, String puerto, String usuario, String password, String basedatos) {
        this.ip = ip;
        this.puerto = puerto;
        this.usuario = usuario;
        this.password = password;
        this.basedatos = basedatos;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasedatos() {
        return basedatos;
    }

    public void setBasedatos(String basedatos) {
        this.basedatos = basedatos;
    }

    public String getTiposervidor() {
        return tiposervidor;
    }

    public void setTiposervidor(String tiposervidor) {
        this.tiposervidor = tiposervidor;
    }
    /**
     * retorna la cadena de conexion del servidor
     * @return 
     */
    public String getCadenaConexion() {
        //jdbc:derby://localhost:1527/PROCEDIMIENTOS
        //jdbc:mysql://localhost:3306/JUEZ
        return this.toString();
        //return ip + puerto + driver + usuario + password +  basedatos ;
    }
    @Override
    public String toString() {
        //jdbc:derby://localhost:1527/PROCEDIMIENTOS
        //jdbc:mysql://localhost:3306/JUEZ
        return "jdbc:" + this.tiposervidor + "://" + ip +":"+puerto+"/"+basedatos;
        //return ip + puerto + driver + usuario + password +  basedatos ;
    }
    
    public String getDriverClass(TipoServidor tiposervidor){
        this.tiposervidor= tiposervidor.toString();
        switch(tiposervidor){    
            case derby:
                this.setDriver("org.apache.derby.jdbc.ClientDriver");
                return this.getDriver();
            case mysql:
                 this.setDriver("com.mysql.jdbc.Driver");
                return this.getDriver();
               
            case mariadb:
                 this.setDriver("org.mariadb.jdbc.Driver");
                return this.getDriver();
              
            case  oracle:
                 this.setDriver("org.apache.derby.jdbc.ClientDriver");
                return this.getDriver();
                
            default:
                 this.setDriver("org.apache.derby.jdbc.ClientDriver");
                return this.getDriver();
                
                
        }
    }
            
    
//    public static String getDriverClass(String tiposervidor){
//        
//        if(tiposervidor.matches("derby")){
//            
//            return "org.apache.derby.jdbc.ClientDriver";
//        }
//        
//         if(tiposervidor.matches("mysql")){
//            return "com.mysql.jdbc.Driver";
//        }
//         return "org.apache.derby.jdbc.ClientDriver";
//        
//    }
    
    
}
