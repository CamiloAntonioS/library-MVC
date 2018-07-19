/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Renzo
 */
public class DatosAdministrador {

    private Connection conexion;
    private Statement comando;
    private ResultSet resultado;

    /**
     *
     */
    private Conexion miConexion;

    /**
     *
     * @throws Exception
     */
    public DatosAdministrador() throws Exception {
        try {
            miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList getPerfiles() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM perfil WHERE esta_activo=1 ORDER BY id";
            this.setResultado(getComando().executeQuery(sql));
            ArrayList<String> perfiles = new ArrayList<>();
            String perfil;
            while (this.getResultado().next()) {
                perfil = this.getResultado().getInt("id") + ":" + this.getResultado().getString("nombre");
                perfiles.add(perfil);
            }
            return perfiles;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList getSedes() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM sede WHERE esta_activo=1 ORDER BY id";
            this.setResultado(getComando().executeQuery(sql));
            ArrayList<String> perfiles = new ArrayList<>();
            String perfil;
            while (this.getResultado().next()) {
                perfil = this.getResultado().getInt("id") + ":" + this.getResultado().getString("nombre");
                perfiles.add(perfil);
            }
            return perfiles;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList getCarreras() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM carrera ORDER BY id";
            this.setResultado(getComando().executeQuery(sql));
            ArrayList<String> perfiles = new ArrayList<>();
            String perfil;
            while (this.getResultado().next()) {
                perfil = this.getResultado().getInt("id") + ":" + this.getResultado().getString("nombre");
                perfiles.add(perfil);
            }
            return perfiles;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws java.sql.SQLException @throws Exception
     */
    public int registrarUsuario(String rut, String password, String nombre, int perfil, int sede, int carrera) throws SQLException {
        int res = 0;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "INSERT INTO `usuario`(`rut`, `password`, `nombre`, `perfil`, `sede`, `carrera`) VALUES ("
                    + "'" + rut + "',"
                    + "'" + password + "',"
                    + "'" + nombre + "',"
                    + perfil + ","
                    + sede + ","
                    + carrera + ")";
            res = getComando().executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    public void ingresarRegistroCSV(BufferedReader archivo) throws SQLException, IOException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "INSERT INTO `usuario`(`rut`, `password`, `nombre`, `perfil`, `sede`, `carrera`) VALUES (?,?,?,?,?,?)";
            String linea = "";
            int primeraLinea = 0;
            while ((linea = archivo.readLine()) != null) {
                if (linea != null && primeraLinea > 0) {
                    String[] array = linea.split(";");
                    PreparedStatement ps = this.getConexion().prepareStatement(sql);
                    ps.setString(1, array[0]);
                    ps.setString(2, array[1]);
                    ps.setString(3, array[2]);
                    ps.setInt(4, Integer.valueOf(array[3]));
                    ps.setInt(5, Integer.valueOf(array[4]));
                    ps.setInt(6, Integer.valueOf(array[5]));
                    ps.executeUpdate();
                    ps.close();
                }
                primeraLinea++;
            }
            if (archivo == null) {
                archivo.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * @return the comando
     */
    public Statement getComando() {
        return comando;
    }

    /**
     * @param comando the comando to set
     */
    public void setComando(Statement comando) {
        this.comando = comando;
    }

    /**
     * @return the resultado
     */
    public ResultSet getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the miConexion
     */
    public Conexion getMiConexion() {
        return miConexion;
    }

    /**
     * @param miConexion the miConexion to set
     */
    public void setMiConexion(Conexion miConexion) {
        this.miConexion = miConexion;
    }

}
