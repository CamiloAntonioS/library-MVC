/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosFuncionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renzo
 */

/**
 *
 * @author Renzo
 */
public class Funcionario extends Usuario{
    
    DatosFuncionario dbFuncionario;
    
    public Funcionario(int id, String rut, String nombre, int perfil, int sede, int carrera) {
        super(id, rut, nombre, perfil, sede, carrera);
    }

    public Funcionario(String username, String password) {
        super(username, password);
    }
    
    public ResultSet listarPrestamosBiblioteca() throws SQLException, Exception{
        try {
            this.dbFuncionario = new DatosFuncionario();
            this.dbFuncionario.setSede(this.getSede());
            ResultSet rs =  this.dbFuncionario.listarPrestamosBiblioteca();
            return rs;
        } catch (Exception ex) {
           throw ex;
        }
    }
    
}