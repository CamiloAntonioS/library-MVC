/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosLibro;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ResultSet todoLibros;
    private ResultSet todoLibrosTabla;

    /**
     *
     * @param id
     * @param nombre
     * @param autor
     * @param genero
     * @param demanda
     * @param cantidad
     * @param paginas
     * @param biblioteca
     */
    public Libro(int id, String nombre, int autor, int genero, String demanda, int cantidad, int paginas, int biblioteca) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.demanda = demanda;
        this.cantidad = cantidad;
        this.paginas = paginas;
        this.biblioteca = biblioteca;
    }
    
    /*
    Este constructor solo se utiliza para traer todos los libros de la DB!
    */

    /**
     *
     */

    public Libro() {
        this.traerLibros();
        this.traerLibrosTabla();
    }

    private void traerLibros() {
        DatosLibro datosLibro;
        try {
            datosLibro = new DatosLibro();
            todoLibros = datosLibro.TraerTodo();
        } catch (Exception ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void traerLibrosTabla() {
        DatosLibro datosLibro;
        try {
            datosLibro = new DatosLibro();
            todoLibrosTabla = datosLibro.TraerTodoParaTabla();
        } catch (Exception ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param filtro_nombre
     * @param filtro_autor
     * @param filtro_cat
     * @param filtro_idioma
     * @param filtro_demanda
     * @return
     * @throws Exception
     */
    public ResultSet filtrarLibreria(String filtro_nombre,String filtro_autor, String filtro_cat, String filtro_idioma, String filtro_demanda) throws Exception{
        try {
            DatosLibro datosLibro = new DatosLibro();
            ResultSet rs= datosLibro.Buscar(filtro_nombre,filtro_autor,filtro_cat,filtro_idioma,filtro_demanda);
            return rs;
        } catch (Exception ex) {
           throw ex;
        }
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

    /**
     * @return the biblioteca
     */
    public int getBiblioteca() {
        return biblioteca;
    }

    /**
     * @return the todoLibros
     */
    public ResultSet getTodoLibros() {
        return todoLibros;
    }

    /**
     * @return the todoLibrosTabla
     */
    public ResultSet getTodoLibrosTabla() {
        return todoLibrosTabla;
    }

}
