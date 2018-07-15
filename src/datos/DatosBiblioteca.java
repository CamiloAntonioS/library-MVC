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

/**
 *
 * @author Renzo
 */
public class DatosBiblioteca {

    private Connection conexion;
    private Statement comando;
    private ResultSet resultado;

    private Conexion miConexion;

    private int id;
    private String nombre;
    private int sede;
    private String ubicacion;

    /**
     *
     * @throws Exception
     */
    public DatosBiblioteca() throws Exception {
        try {
            this.miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ResultSet listarPrestamosBiblioteca() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    //+ "libro.id,"
                    + "libro.nombre,"
                    //+ "categoria.nombre,"
                    + "usuario.rut,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "CURRENT_DATE-fecha_entrega AS atraso,"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    //+ "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.sede= " + this.getSede() + " AND prestamos.entregado=0";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @param filtro_nombre
     * @param filtro_rut
     * @return
     * @throws SQLException
     */
    public ResultSet filtrarPrestamosBiblioteca(String filtro_nombre, String filtro_rut) throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    //+ "libro.id,"
                    + "libro.nombre,"
                    //+ "categoria.nombre,"
                    + "usuario.rut,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "CURRENT_DATE-fecha_entrega AS atraso,"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    //+ "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.sede= " + this.getSede() + " AND prestamos.entregado=0"
                    + " AND libro.nombre LIKE '%" + filtro_nombre + "%'"
                    + " AND usuario.rut LIKE '%" + filtro_rut + "%'";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ResultSet listarPrestamosAceptacionBiblioteca() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    //+ "libro.id,"
                    + "libro.nombre,"
                    //+ "categoria.nombre,"
                    + "usuario.rut,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "CURRENT_DATE-fecha_entrega AS atraso,"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    //+ "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.sede= " + this.getSede() + " AND prestamos.entregado=0 AND prestamos.pendiente_aceptacion=1";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @param filtro_nombre
     * @param filtro_rut
     * @return
     * @throws SQLException
     */
    public ResultSet filtrarPrestamosAceptacionBiblioteca(String filtro_nombre, String filtro_rut) throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    //+ "libro.id,"
                    + "libro.nombre,"
                    //+ "categoria.nombre,"
                    + "usuario.rut,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "CURRENT_DATE-fecha_entrega AS atraso,"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    //+ "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.sede= " + this.getSede() + " AND prestamos.entregado=0 AND prestamos.pendiente_aceptacion=1"
                    + " AND libro.nombre LIKE '%" + filtro_nombre + "%'"
                    + " AND usuario.rut LIKE '%" + filtro_rut + "%'";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sede
     */
    public int getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(int sede) {
        this.sede = sede;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
