/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosFuncionario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Renzo
 */
public class Funcionario extends Usuario {

    /**
     *
     */
    public Funcionario() {
    }

    /**
     * @return the dbFuncionario
     */
    public DatosFuncionario getDbFuncionario() {
        return dbFuncionario;
    }

    /**
     * @param dbFuncionario the dbFuncionario to set
     */
    public void setDbFuncionario(DatosFuncionario dbFuncionario) {
        this.dbFuncionario = dbFuncionario;
    }

    /**
     * @return the biblioteca
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * @param biblioteca the biblioteca to set
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    private DatosFuncionario dbFuncionario;
    private Biblioteca biblioteca;

    /**
     *
     * @param id
     * @param rut
     * @param nombre
     * @param perfil
     * @param sede
     * @param carrera
     */
    public Funcionario(int id, String rut, String nombre, int perfil, int sede, int carrera) {
        super(id, rut, nombre, perfil, sede, carrera);
    }

    /**
     *
     * @param username
     * @param password
     */
    public Funcionario(String username, String password) {
        super(username, password);
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ResultSet listarPrestamosBiblioteca() throws SQLException, Exception {
        try {
            this.setBiblioteca(new Biblioteca());
            this.getBiblioteca().setSede(this.getSede());
            ResultSet rs = this.getBiblioteca().listarPrestamosBiblioteca();
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
            this.setBiblioteca(new Biblioteca());
            this.getBiblioteca().setSede(this.getSede());
            ResultSet rs = this.getBiblioteca().filtrarPrestamosBiblioteca(filtro_texto, filtro_rut);
            return rs;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ResultSet listarPrestamosAceptacionBiblioteca() throws SQLException, Exception {
        try {
            this.setBiblioteca(new Biblioteca());
            this.getBiblioteca().setSede(this.getSede());
            ResultSet rs = this.getBiblioteca().listarPrestamosAceptacionBiblioteca();
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
            this.setBiblioteca(new Biblioteca());
            this.getBiblioteca().setSede(this.getSede());
            ResultSet rs = this.getBiblioteca().filtrarPrestamosAceptacionBiblioteca(filtro_texto, filtro_rut);
            return rs;
        } catch (Exception ex) {
            throw ex;
        }
    }


}
