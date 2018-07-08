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
public class Biblioteca {
    private int id;
    private String nombre;
    private int sede;
    private String ubicacion;

    public Biblioteca(int id, String nombre, int sede, String ubicacion){
        this.id = id;
        this.nombre = nombre;
        this.sede = sede;
        this.ubicacion = ubicacion;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the sede
     */
    public int getSede() {
        return sede;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }
}
