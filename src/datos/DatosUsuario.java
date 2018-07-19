/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Renzo
 */
public class DatosUsuario {

    /**
     *
     */
    protected Connection conexion;
    private Statement comando;
    private ResultSet resultado;

    /**
     *
     */
    protected Conexion miConexion;

    private int id;
    private String rut;
    private String nombre;
    private int perfil;
    private int sede;
    private String username;
    private String password;
    private int multaAcumulada;
    private int carrera;

    /**
     *
     * @throws Exception
     */
    public DatosUsuario() throws SQLException, Exception {
        try {
            miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public boolean Buscar() throws SQLException {
        boolean res = false;

        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "select * from usuario where rut='" + this.getUsername() + "' and password='" + this.getPassword() + "'";

            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                this.setId(getResultado().getInt("id"));
                this.setRut(getResultado().getString("rut"));
                this.setNombre(getResultado().getString("nombre"));
                this.setPerfil(getResultado().getInt("perfil"));
                this.setSede(getResultado().getInt("sede"));
                this.setCarrera(getResultado().getInt("carrera"));
                res = true;
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    public boolean buscarDuplicado(String rut) throws SQLException {
        boolean res = false;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "select * from usuario where rut='" + rut + "'";
            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                res = true;
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    /**
     *
     * @return @throws SQLException
     */
    public boolean obtenerDatosPrestamo() throws SQLException {
        boolean res = false;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM `usuario_multas` WHERE rut='" + this.getRut() + "'";

            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                this.setId(getResultado().getInt("id_usuario"));
                this.setNombre(getResultado().getString("nombre"));
                this.setPerfil(getResultado().getInt("perfil_id"));
                this.setSede(getResultado().getInt("sede_id"));
                this.setMultaAcumulada(getResultado().getInt("multa_pagada"));
                res = true;
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public ResultSet traerTodo() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM usuario ORDER BY id";
            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public ResultSet listarPrestamos() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    + "libro.id,"
                    + "libro.nombre,"
                    + "categoria.nombre,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "CURRENT_DATE-fecha_entrega AS atraso,"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    + "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.id= " + this.id + " AND prestamos.entregado=0";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @param nombre_texto
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet filtrarPrestamos(String nombre_texto) throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    + "libro.id,"
                    + "libro.nombre,"
                    + "categoria.nombre,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "(prestamos.fecha_prestamo-prestamos.fecha_entrega),"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    + "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.id= " + this.id + " "
                    + "AND libro.nombre LIKE '%" + nombre_texto + "%' AND prestamos.entregado=0";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @param id_prestamo
     * @return
     * @throws java.sql.SQLException
     */
    public int solicitarRenovacion(int id_prestamo) throws SQLException {
        int res = 0;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "UPDATE  prestamos SET  pendiente_aceptacion=1  WHERE id=" + id_prestamo;
            res = getComando().executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    /**
     *
     * @param id_prestamo
     * @return
     * @throws SQLException
     */
    public int checkearSolicitud(int id_prestamo) throws SQLException {
        int res = -1;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT pendiente_aceptacion FROM prestamos where id=" + id_prestamo;

            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                res = getResultado().getInt("pendiente_aceptacion");
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the carrera
     */
    public int getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the perfil
     */
    public int getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(int perfil) {
        this.perfil = perfil;
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
     * @return the multaAcumulada
     */
    public int getMultaAcumulada() {
        return multaAcumulada;
    }

    /**
     * @param multaAcumulada the multaAcumulada to set
     */
    public void setMultaAcumulada(int multaAcumulada) {
        this.multaAcumulada = multaAcumulada;
    }

}
