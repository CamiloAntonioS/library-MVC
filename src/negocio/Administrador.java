/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosAdministrador;
import java.io.BufferedReader;
import java.io.IOException;
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

    public void registrarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario.getRut().equals("")) {
                throw new Exception("El rut no puede ser un valor vacío!.");
            } else if (usuario.buscarDuplicado()) {
                throw new Exception("El rut ya se encuentra registrado en el sistema!.");
            } else if (usuario.getNombre().equals("")) {
                throw new Exception("Debe ingresar un nombre de usuario!.");
            } else if (usuario.getPassword().equals("")) {
                throw new Exception("La contraseña no puede estar en blanco!.");
            }
            this.dbAdmin.registrarUsuario(usuario.getRut(), usuario.getPassword(), usuario.getNombre(), usuario.getPerfil(), usuario.getSede(), usuario.getCarrera());
        } catch (SQLException ex) {
            throw new Exception("Ha ocurrido un problema en la conexión con la base de Datos.\nFavor contactar al administrador de la plataforma.");
        }
    }

    public void ingresarRegistroCSV(BufferedReader archivo) throws SQLException, IOException {
        this.dbAdmin.ingresarRegistroCSV(archivo);
    }

}
