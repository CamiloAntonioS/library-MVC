/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Renzo
 */
public class Usuario {

    private int id;
    private String rut;
    private String nombre;
    private int perfil;
    private int sede;
    private String username;
    private String password;
    private int carrera;
    private DatosUsuario dbUsuario;

    /**
     *
     * @param id
     * @param rut
     * @param nombre
     * @param perfil
     * @param sede
     * @param carrera
     */
    public Usuario(int id, String rut, String nombre, int perfil, int sede, int carrera) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.perfil = perfil;
        this.sede = sede;
        this.carrera = carrera;
    }

    /**
     *
     * @param username
     * @param password
     */
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return this.rut;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the perfil
     */
    public int getPerfil() {
        return this.perfil;
    }

    /**
     * @return the sede
     */
    public int getSede() {
        return this.sede;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the carrera
     */
    public int getCarrera() {
        return carrera;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean iniciarSesion(String username, String password) throws Exception {
        this.dbUsuario = new DatosUsuario();
        this.dbUsuario.setUsername(username);
        this.dbUsuario.setPassword(password);
        if (dbUsuario.Buscar()) {
            this.id = dbUsuario.getId();
            this.rut = dbUsuario.getRut();
            this.nombre = dbUsuario.getNombre();
            this.perfil = dbUsuario.getPerfil();
            this.sede = dbUsuario.getSede();
            this.carrera = dbUsuario.getCarrera();
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return @throws java.sql.SQLException
     */
    public ResultSet listarPrestamos() throws SQLException {
        ResultSet rs;
        this.dbUsuario.setId(this.id);
        rs = this.dbUsuario.listarPrestamos();
        return rs;
    }

    /**
     *
     * @param nombre_texto
     * @return rs
     * @throws java.sql.SQLException
     */
    public ResultSet filtrarPrestamos(String nombre_texto) throws SQLException {
        ResultSet rs;
        this.dbUsuario.setId(this.id);
        rs = this.dbUsuario.filtrarPrestamos(nombre_texto);
        return rs;
    }

    /**
     *
     * @param id_prestamo
     * @return 1=Fila Afectada 2=Ninguna fila afectada (Extensión ya solicitada)
     * @throws java.sql.SQLException
     */
    public int solicitarRenovacion(int id_prestamo) throws SQLException, Exception {
        switch (this.dbUsuario.checkearSolicitud(id_prestamo)) {
            case 0:
                int registroAfectado = this.dbUsuario.solicitarRenovacion(id_prestamo);
                if (registroAfectado == 1) {
                    return 1;
                }  else {
                    throw new Exception("");
                }
            case 1:
                return 2;
        }
        return -1;
    }
}
