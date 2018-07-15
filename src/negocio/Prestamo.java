/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosPrestamo;
import java.sql.SQLException;

/**
 *
 * @author Renzo
 */
public class Prestamo {

    private int idPrestamo;
    private int prestamo_usuario;
    private int perfil_usuario;
    private int prestamo_libro;
    private String nombre_libro;
    private String demanda_libro;
    private int prestamo_funcionario;
    private int diasAtraso;
    private DatosPrestamo dbPrestamo;

    /**
     *
     * @param idPrestamo
     * @param prestamo_usuario
     * @param perfil_usuario
     * @param prestamo_libro
     * @param nombre_libro
     * @param demanda_libro
     * @param prestamo_funcionario
     * @param diasAtraso
     * @param dbPrestamo
     */
    public Prestamo(int idPrestamo, int prestamo_usuario, int perfil_usuario, int prestamo_libro, String nombre_libro, String demanda_libro, int prestamo_funcionario, int diasAtraso, DatosPrestamo dbPrestamo) {
        this.idPrestamo = idPrestamo;
        this.prestamo_usuario = prestamo_usuario;
        this.perfil_usuario = perfil_usuario;
        this.prestamo_libro = prestamo_libro;
        this.nombre_libro = nombre_libro;
        this.demanda_libro = demanda_libro;
        this.prestamo_funcionario = prestamo_funcionario;
        this.diasAtraso = diasAtraso;
        this.dbPrestamo = dbPrestamo;
    }

    /**
     *
     * @param idPrestamo
     * @throws Exception
     */
    public Prestamo(int idPrestamo) throws Exception {
        this.idPrestamo = idPrestamo;
        this.dbPrestamo = new DatosPrestamo();
    }

    /**
     *
     * @throws SQLException
     * @throws Exception
     */
    public void obtenerDatos() throws SQLException, Exception {
        if (this.dbPrestamo.obtenerDatos(this.idPrestamo)) {
            this.datosaNegocio();
        } else {
            throw new Exception("Ha ocurrido un problema al buscar el prestamo solicitado.\nIntente nuevamente en unos segundos.");
        }
    }

    /**
     *
     * @throws SQLException
     */
    public void registrarDevolución() throws SQLException {
        this.dbPrestamo.setIdPrestamo(this.idPrestamo);
        this.dbPrestamo.registrarDevolucion();
    }

    void registrarDevoluciónMultada(int multa) throws SQLException {
        this.dbPrestamo.setIdPrestamo(this.idPrestamo);
        this.dbPrestamo.registrarDevolucionMultada(multa);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public String nombreTexto() throws SQLException {
        this.dbPrestamo.setIdPrestamo(this.idPrestamo);
        this.dbPrestamo.obtenerDatos(this.idPrestamo);
        return this.dbPrestamo.getNombre_libro();
    }

    private void datosaNegocio() {
        this.prestamo_usuario = this.dbPrestamo.getPrestamo_usuario();
        this.perfil_usuario = this.dbPrestamo.getPerfil_usuario();
        this.prestamo_libro = this.dbPrestamo.getPrestamo_libro();
        this.nombre_libro = this.dbPrestamo.getNombre_libro();
        this.demanda_libro = this.dbPrestamo.getDemanda_libro();
        this.prestamo_funcionario = this.dbPrestamo.getPrestamo_funcionario();
        this.diasAtraso = this.dbPrestamo.getDiasAtraso();
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

    /**
     * @return the dbPrestamo
     */
    public DatosPrestamo getDbPrestamo() {
        return dbPrestamo;
    }

    /**
     * @param dbPrestamo the dbPrestamo to set
     */
    public void setDbPrestamo(DatosPrestamo dbPrestamo) {
        this.dbPrestamo = dbPrestamo;
    }

}
