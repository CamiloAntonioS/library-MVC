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

    public ResultSet listarMultadosSede(int sede) throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT rut,nombre,perfil,sede,multa_pagada FROM usuario_multas WHERE sede_id=" + sede;
            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public ResultSet listarMultados() throws SQLException {
        try {
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT rut,nombre,perfil,sede,multa_pagada FROM usuario_multas";
            setResultado(getComando().executeQuery(sql));
            return getResultado();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public int totalMultasSede(int sede) throws SQLException {
        try {
            int total = 0;
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT sum(multa_pagada) as total FROM usuario_multas WHERE sede_id=" + sede;
            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                total = getResultado().getInt("total");
            }
            return total;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public int totalMultas() throws SQLException {
        try {
            int total = 0;
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT sum(multa_pagada) as total FROM usuario_multas";
            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                total = getResultado().getInt("total");
            }
            return total;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public String libroMasMultado() throws SQLException {
        try {
            String libro = "";
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM `libro_mas_multado` LIMIT 1";
            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                libro = getResultado().getString("nombre");
            }
            return libro;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public String libroMasMultadoSede(int sede) throws SQLException {
        try {
            String libro = "";
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM `libro_mas_multado` WHERE prestamo_sede = " + sede + " LIMIT 1";
            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                libro = getResultado().getString("nombre");
            }
            return libro;
        } catch (SQLException ex) {
            throw ex;
        }
    }
        public String sedeMasMultada() throws SQLException {
        try {
            String libro = "";
            this.setComando(this.getConexion().createStatement());
            String sql = "SELECT * FROM `sede_mas_multada` ";
            setResultado(getComando().executeQuery(sql));
            while (getResultado().next()) {
                libro = getResultado().getString("nombre");
            }
            return libro;
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
