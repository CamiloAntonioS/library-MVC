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

    public DatosFuncionario() throws Exception{
        try {
            this.miConexion = new Conexion();
            this.conexion = miConexion.getConexion();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ResultSet listarPrestamosBiblioteca() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT "
                    + "prestamos.id,"
                    //+ "libro.id,"
                    + "libro.nombre,"
                    //+ "categoria.nombre,"
                    + "usuario.rut,"
                    + "prestamos.fecha_prestamo,"
                    + "prestamos.fecha_entrega,"
                    + "(prestamos.fecha_prestamo-prestamos.fecha_entrega),"
                    + "prestamos.renovado "
                    + "FROM prestamos\n"
                    + "INNER JOIN usuario ON usuario.id = prestamos.prestamo_usuario\n"
                    + "INNER JOIN libro ON libro.id = prestamos.prestamo_libro\n"
                    //+ "INNER JOIN categoria ON categoria.id = libro.categoria "
                    + "WHERE usuario.sede= " + this.getSede() + " AND prestamos.entregado=0";

            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
