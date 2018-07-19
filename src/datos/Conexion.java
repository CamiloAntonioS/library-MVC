/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Renzo
 */
public class Conexion {
    private Connection conexion;
    private DriverManager driver;   
    
    /**
     *
     * @throws Exception
     */
    public Conexion() throws Exception{
        conexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/libreria?user=root&password=");
        }
        catch(ClassNotFoundException ex){
            throw new Exception("Falta el Driver de Mysql");
        }
        catch(SQLException e1){
            throw new Exception("No se logro la conexión al servidor.");
        }
    }
    
    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }
}
