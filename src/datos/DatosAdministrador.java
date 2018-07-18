/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
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
