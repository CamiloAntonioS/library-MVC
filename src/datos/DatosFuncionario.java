/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Renzo
 */
public class DatosFuncionario extends DatosUsuario {

    /**
     *
     * @throws Exception
     */
    public DatosFuncionario() throws Exception {
        try {
            this.miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
