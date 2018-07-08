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
public class DatosLibro {

    private Connection conexion;
    private Statement comando;
    private ResultSet resultado;

    private Conexion miConexion;

    private int id;
    private String rut;
    private String nombre;
    private int perfil;
    private int sede;
    private String username;
    private String password;
    private int carrera;

    public DatosLibro() throws Exception {
        try {
            miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int Guardar() throws Exception {
        int res = 0;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "insert into usuario (rut, nombre, password) values ('" + this.getRut() + "','" + this.getNombre() + "','" + this.getPassword() + "')";
            res = getComando().executeUpdate(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return res;
    }

    public int Modificar() {
        int res = 0;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "update usuario set nombre='" + this.getNombre() + "', password='" + this.getPassword() + "' where rut='" + this.getRut() + "'";

            res = getComando().executeUpdate(sql);

        } catch (SQLException ex) {
            //capturamos SQLException Hacer Algo
        }
        return res;
    }

    public int Eliminar() {
        int res = 0;
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "delete from usuario where rut='" + this.getRut() + "'";

            res = getComando().executeUpdate(sql);
        } catch (SQLException ex) {
            //capturamos SQLException Hacer Algo
        }
        return res;
    }

    public ResultSet Buscar(String filtro_nombre, String filtro_autor, String filtro_cat, String filtro_idioma, String filtro_demanda) {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "libro.id,"
                    + "libro.nombre,"
                    + "autor.nombre,"
                    + "categoria.nombre,"
                    + "libro.idioma,"
                    + "libro.cantidad,"
                    + "libro.paginas,"
                    + "libro.demanda,"
                    + "libro_estado.estado "
                    + "FROM `libro`\n"
                    + "INNER JOIN autor ON autor.id = libro.autor\n"
                    + "INNER JOIN categoria ON categoria.id = libro.categoria\n"
                    + "INNER JOIN libro_estado ON libro_estado.id = libro.estado\n"
                    + "WHERE libro.nombre LIKE '%" + filtro_nombre + "%' "
                    + "AND autor.nombre LIKE '%" + filtro_autor + "%' "
                    + "AND categoria.nombre LIKE '%" + filtro_cat + "%' "
                    + "AND libro.idioma LIKE '%" + filtro_idioma+ "%' "
                    + "AND libro.demanda LIKE '%" + filtro_demanda + "%' ";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            return null;
        }

    }

    public ResultSet TraerTodo() {

        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "select * from libro";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            return null;
        }

    }

    public ResultSet TraerTodoParaTabla() {

        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "libro.id,"
                    + "libro.nombre,"
                    + "autor.nombre,"
                    + "categoria.nombre,"
                    + "libro.idioma,"
                    + "libro.cantidad,"
                    + "libro.paginas,"
                    + "libro.demanda,"
                    + "libro_estado.estado "
                    + "FROM `libro`\n"
                    + "INNER JOIN autor ON autor.id = libro.autor\n"
                    + "INNER JOIN categoria ON categoria.id = libro.categoria\n"
                    + "INNER JOIN libro_estado ON libro_estado.id = libro.estado";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            return null;
        }

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

}
