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
public class DatosPrestamo {

    private Connection conexion;
    private Statement comando;
    private ResultSet resultado;

    private Conexion miConexion;

    private int idPrestamo;
    private int prestamo_usuario;
    private int perfil_usuario;
    private int prestamo_libro;
    private String nombre_libro;
    private String demanda_libro;
    private int prestamo_funcionario;
    private int diasAtraso;

    /**
     *
     * @throws Exception
     */
    public DatosPrestamo() throws Exception {
        try {
            this.miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param idPrestamo
     * @return
     * @throws SQLException
     */
    public boolean obtenerDatos(int idPrestamo) throws SQLException {
        try {
            ResultSet rs;
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM `vista_devolucion_prestamo` WHERE id=" + idPrestamo;
            setResultado(getComando().executeQuery(sql));
            rs = getResultado();
            while (rs.next()) {
                this.setIdPrestamo(rs.getInt("id"));
                this.setPrestamo_usuario(rs.getInt("prestamo_usuario"));
                this.setPerfil_usuario(rs.getInt("perfil"));
                this.setPrestamo_libro(rs.getInt("prestamo_libro"));
                this.setNombre_libro(rs.getString("nombre"));
                this.setDemanda_libro(rs.getString("demanda"));
                this.setPrestamo_funcionario(rs.getInt("prestamo_funcionario"));
                this.setDiasAtraso(rs.getInt("atraso"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int registrarDevolucion() throws SQLException {
        int res = 0;
        try {
            java.sql.Date actual = new java.sql.Date(new java.util.Date().getTime());
            this.setComando(this.getConexion().createStatement());
            String sql = "UPDATE `prestamos` SET `entregado` = 1"
                    + ", fecha_entregado='" + actual
                    + "' WHERE `prestamos`.`id` =" + this.idPrestamo;
            res = getComando().executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    /**
     *
     * @param multa
     * @return
     * @throws SQLException
     */
    public int registrarDevolucionMultada(int multa) throws SQLException {
        int res = 0;
        try {
            java.sql.Date actual = new java.sql.Date(new java.util.Date().getTime());
            this.setComando(this.getConexion().createStatement());
            String sql = "UPDATE `prestamos` SET `entregado` = 1"
                    + ", fecha_entregado='" + actual
                    + "' ,multa_pagada=" + multa
                    + " WHERE `prestamos`.`id` =" + this.idPrestamo;
            res = getComando().executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    /**
     *
     * @param idPrestamo
     * @return
     * @throws SQLException
     */
    public int registrarRenovacion(int idPrestamo) throws SQLException {
        int res = 0;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "UPDATE `prestamos` SET `fecha_entrega` = fecha_entrega+7 WHERE `prestamos`.`id` =" + idPrestamo;
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

    /**
     * @return the idPrestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return the prestamo_usuario
     */
    public int getPrestamo_usuario() {
        return prestamo_usuario;
    }

    /**
     * @param prestamo_usuario the prestamo_usuario to set
     */
    public void setPrestamo_usuario(int prestamo_usuario) {
        this.prestamo_usuario = prestamo_usuario;
    }

    /**
     * @return the perfil_usuario
     */
    public int getPerfil_usuario() {
        return perfil_usuario;
    }

    /**
     * @param perfil_usuario the perfil_usuario to set
     */
    public void setPerfil_usuario(int perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    /**
     * @return the prestamo_libro
     */
    public int getPrestamo_libro() {
        return prestamo_libro;
    }

    /**
     * @param prestamo_libro the prestamo_libro to set
     */
    public void setPrestamo_libro(int prestamo_libro) {
        this.prestamo_libro = prestamo_libro;
    }

    /**
     * @return the nombre_libro
     */
    public String getNombre_libro() {
        return nombre_libro;
    }

    /**
     * @param nombre_libro the nombre_libro to set
     */
    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    /**
     * @return the demanda_libro
     */
    public String getDemanda_libro() {
        return demanda_libro;
    }

    /**
     * @param demanda_libro the demanda_libro to set
     */
    public void setDemanda_libro(String demanda_libro) {
        this.demanda_libro = demanda_libro;
    }

    /**
     * @return the prestamo_funcionario
     */
    public int getPrestamo_funcionario() {
        return prestamo_funcionario;
    }

    /**
     * @param prestamo_funcionario the prestamo_funcionario to set
     */
    public void setPrestamo_funcionario(int prestamo_funcionario) {
        this.prestamo_funcionario = prestamo_funcionario;
    }

    /**
     * @return the diasAtraso
     */
    public int getDiasAtraso() {
        return diasAtraso;
    }

    /**
     * @param diasAtraso the diasAtraso to set
     */
    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

}
