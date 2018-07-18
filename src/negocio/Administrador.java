/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosAdministrador;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Renzo
 */
public class Administrador extends Usuario {

    private DatosAdministrador dbAdmin;

    /**
     *
     * @param id
     * @param rut
     * @param nombre
     * @param perfil
     * @param sede
     * @throws Exception
     */
    public Administrador(int id, String rut, String nombre, int perfil, int sede) throws Exception {
        this.setId(id);
        this.setRut(rut);
        this.setNombre(nombre);
        this.setPerfil(perfil);
        this.setSede(sede);
        this.dbAdmin = new DatosAdministrador();
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList getPerfiles() throws SQLException {
        ArrayList perfiles = this.dbAdmin.getPerfiles();
        return perfiles;
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList getSedes() throws SQLException {
        ArrayList sedes = this.dbAdmin.getSedes();
        return sedes;
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList getCarreras() throws SQLException {
        ArrayList carreras = this.dbAdmin.getCarreras();
        return carreras;
    }

    public void registrarUsuario(Usuario usuario) throws SQLException {
        this.dbAdmin.registrarUsuario(usuario.getRut(),usuario.getPassword(),usuario.getNombre(),usuario.getPerfil(),usuario.getSede(),usuario.getCarrera());
    }

}
