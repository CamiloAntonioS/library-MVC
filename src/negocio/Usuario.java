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
public class Usuario {
    
    public Usuario(int id, String rut, String nombre, int perfil, int sede){
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.perfil = perfil;
        this.sede = sede;
    }
    
    private int id;
    private String rut;
    private String nombre;
    private int perfil;
    private int sede;    

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
        return this.rut;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the perfil
     */
    public int getPerfil() {
        return this.perfil;
    }

    /**
     * @return the sede
     */
    public int getSede() {
        return this.sede;
    }
}

class Alumno extends Usuario{
    protected int carrera;

    public Alumno(int id, String rut, String nombre, int perfil, int sede, int carrera) {
        super(id, rut, nombre, perfil, sede);
        this.carrera = carrera;
    }
    
     /**
     * @return the sede
     */
    public int getCarrera() {
        return this.carrera;
    }
}

class Docente extends Usuario{
    protected int carrera;

    public Docente(int id, String rut, String nombre, int perfil, int sede,int carrera) {
        super(id, rut, nombre, perfil, sede);
        this.carrera = carrera;
    }
    
     /**
     * @return the sede
     */
    public int getCarrera() {
        return this.carrera;
    }
}