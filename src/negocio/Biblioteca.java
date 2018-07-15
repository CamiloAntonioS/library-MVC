/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosBiblioteca;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Renzo
 */
public class Biblioteca {

    /**
     *
     */
    static public int MULTA_POR_DIA = 500;
    private int id;
    private String nombre;
    private int sede;
    private String ubicacion;
    private DatosBiblioteca dbBiblioteca;

    /**
     *
     * @param id
     * @param nombre
     * @param sede
     * @param ubicacion
     */
    public Biblioteca(int id, String nombre, int sede, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.sede = sede;
        this.ubicacion = ubicacion;
    }

    /**
     *
     */
    public Biblioteca() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the sede
     */
    public int getSede() {
        return sede;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(int sede) {
        this.sede = sede;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     *
     * @return @throws SQLException
     * @throws Exception
     */
    public ResultSet listarPrestamosBiblioteca() throws SQLException, Exception {
        try {
            this.dbBiblioteca = new DatosBiblioteca();
            this.dbBiblioteca.setSede(this.sede);
            ResultSet rs = this.dbBiblioteca.listarPrestamosBiblioteca();
            return rs;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param filtro_texto
     * @param filtro_rut
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ResultSet filtrarPrestamosBiblioteca(String filtro_texto, String filtro_rut) throws SQLException, Exception {
        try {
            this.dbBiblioteca = new DatosBiblioteca();
            this.dbBiblioteca.setSede(this.sede);
            ResultSet rs = this.dbBiblioteca.filtrarPrestamosBiblioteca(filtro_texto, filtro_rut);
            return rs;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     * @throws Exception
     */
    public ResultSet listarPrestamosAceptacionBiblioteca() throws SQLException, Exception {
        try {
            this.dbBiblioteca = new DatosBiblioteca();
            this.dbBiblioteca.setSede(this.sede);
            ResultSet rs = this.dbBiblioteca.listarPrestamosAceptacionBiblioteca();
            return rs;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param filtro_texto
     * @param filtro_rut
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ResultSet filtrarPrestamosAceptacionBiblioteca(String filtro_texto, String filtro_rut) throws SQLException, Exception {
        try {
            this.dbBiblioteca = new DatosBiblioteca();
            this.dbBiblioteca.setSede(this.sede);
            ResultSet rs = this.dbBiblioteca.filtrarPrestamosAceptacionBiblioteca(filtro_texto, filtro_rut);
            return rs;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param idPrestamo
     * @return
     * @throws Exception
     */
    public int validarDevolucion(int idPrestamo) throws Exception {
        try {
            Prestamo prestamoBuscado = new Prestamo(idPrestamo);
            prestamoBuscado.obtenerDatos();
            if (prestamoBuscado.getDiasAtraso() <= 0) {
                return -1;
            }
            if (prestamoBuscado.getDiasAtraso() > 0) {
                return prestamoBuscado.getDiasAtraso();
            }
            return 0;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param idPrestamo
     * @throws Exception
     */
    public void registrarDevolucion(int idPrestamo) throws Exception {
        try {
            Prestamo prestamoBuscado = new Prestamo(idPrestamo);
            prestamoBuscado.obtenerDatos();
            prestamoBuscado.registrarDevolución();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param idPrestamo
     * @return
     * @throws Exception
     */
    public String nombreTextoPrestamo(int idPrestamo) throws Exception {
        Prestamo prestamoBuscado = new Prestamo(idPrestamo);
        return prestamoBuscado.nombreTexto();
    }

    /**
     *
     * @param idPrestamo
     * @param multa
     * @throws Exception
     */
    public void registrarDevolucionMulta(int idPrestamo, int multa) throws Exception {
        Prestamo prestamoBuscado = new Prestamo(idPrestamo);
        prestamoBuscado.obtenerDatos();
        prestamoBuscado.registrarDevoluciónMultada(multa);
    }
}
