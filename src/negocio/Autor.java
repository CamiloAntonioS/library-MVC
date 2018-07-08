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
public class Autor {
    private int id;
    private String nombre;
    private int categoria;
    private String idioma;
    private String pais;
    
    public Autor(int id, String nombre, int categoria, String idioma, String pais){
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.idioma = idioma;
        this.pais = pais;
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
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }
}
