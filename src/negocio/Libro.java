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
public class Libro {
    private int id;
    private String nombre;
    private int autor;
    private int genero;
    private String demanda;
    private int cantidad;
    private int paginas;
    private int biblioteca;
    
    public Libro(int id, String nombre, int autor, int genero, String demanda, int cantidad, int paginas,int biblioteca){
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.demanda = demanda;
        this.cantidad = cantidad;
        this.paginas = paginas;
        this.biblioteca = biblioteca;
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
     * @return the autor
     */
    public int getAutor() {
        return autor;
    }

    /**
     * @return the genero
     */
    public int getGenero() {
        return genero;
    }

    /**
     * @return the demanda
     */
    public String getDemanda() {
        return demanda;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return the paginas
     */
    public int getPaginas() {
        return paginas;
    }
    
}
