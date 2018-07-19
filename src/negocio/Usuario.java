/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.ValidacionRut;

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
    private int multaAcumulada;
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
     * @param rut
     * @throws Exception
     */
    public Usuario(String rut) throws Exception{
        this.setRut(rut);
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
     *
     */
    public Usuario() {
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
        this.setDbUsuario(new DatosUsuario());
        this.getDbUsuario().setUsername(username);
        this.getDbUsuario().setPassword(password);
        if (getDbUsuario().Buscar()) {
            this.setId(getDbUsuario().getId());
            this.setRut(getDbUsuario().getRut());
            this.setNombre(getDbUsuario().getNombre());
            this.setPerfil(getDbUsuario().getPerfil());
            this.setSede(getDbUsuario().getSede());
            this.setCarrera(getDbUsuario().getCarrera());
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
        this.getDbUsuario().setId(this.getId());
        rs = this.getDbUsuario().listarPrestamos();
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
        this.getDbUsuario().setId(this.getId());
        rs = this.getDbUsuario().filtrarPrestamos(nombre_texto);
        return rs;
    }

    /**
     *
     * @param id_prestamo
     * @return 1=Fila Afectada 2=Ninguna fila afectada (Extensión ya solicitada)
     * @throws java.sql.SQLException
     */
    public int solicitarRenovacion(int id_prestamo) throws SQLException, Exception {
        switch (this.getDbUsuario().checkearSolicitud(id_prestamo)) {
            case 0:
                int registroAfectado = this.getDbUsuario().solicitarRenovacion(id_prestamo);
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
    
    /**
     *
     * @return
     * @throws Exception
     */
    public boolean obtenerDatosPrestamo() throws Exception{
        this.setDbUsuario(new DatosUsuario());
        this.getDbUsuario().setRut(this.getRut());
        boolean res = this.getDbUsuario().obtenerDatosPrestamo();
        this.datosaUsuario();
        return res;
    }
    
    private void datosaUsuario(){
        this.setId(this.getDbUsuario().getId());
        this.setNombre(this.getDbUsuario().getNombre());
        this.setPerfil(this.getDbUsuario().getPerfil());
        this.setSede(this.getDbUsuario().getSede());
        this.setMultaAcumulada(this.getDbUsuario().getMultaAcumulada());
    }
    
    /**
     *
     * @return
     * @throws java.lang.Exception
     */
    public ResultSet listarTodo() throws Exception{
        this.setDbUsuario(new DatosUsuario());
        ResultSet rs = this.dbUsuario.traerTodo();
        
        return rs;
    }
    
    public boolean buscarDuplicado() throws Exception{
        this.setDbUsuario(new DatosUsuario());
        return this.getDbUsuario().buscarDuplicado(this.getRut());
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) throws Exception {
        if(!ValidacionRut.IngresoRut(rut)){
            throw new Exception("El rut ingresado no es Valido!.");
        }
        else{
            this.rut = rut;
        }
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(int sede) {
        this.sede = sede;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(int carrera) {
        this.carrera = carrera;
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

    /**
     * @return the dbUsuario
     */
    public DatosUsuario getDbUsuario() {
        return dbUsuario;
    }

    /**
     * @param dbUsuario the dbUsuario to set
     */
    public void setDbUsuario(DatosUsuario dbUsuario) {
        this.dbUsuario = dbUsuario;
    }
}
