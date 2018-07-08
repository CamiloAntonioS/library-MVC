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
public class Categoria {
    private int id;
    private String nombre;
    private String subcategoria;

    public Categoria(int id, String nombre, String subcategoria){
        this.id = id;
        this.nombre = nombre;
        this.subcategoria = subcategoria;
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
     * @return the subcategoria
     */
    public String getSubcategoria() {
        return subcategoria;
    }
}
