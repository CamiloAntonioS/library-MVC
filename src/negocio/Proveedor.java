/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Renzo
 */
public class Proveedor {
    private int id;
    private String rut;
    private String nombre;
    private String comuna;
    private String direccion;

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
        return rut;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the comuna
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }
}
