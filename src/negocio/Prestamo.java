/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DatosPrestamo;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Renzo
 */
public class Prestamo {

    /**
     * @return the cantReno
     */
    public int getCantReno() {
        return cantReno;
    }

    /**
     * @param cantReno the cantReno to set
     */
    public void setCantReno(int cantReno) {
        this.cantReno = cantReno;
    }

    private int idPrestamo;
    private int prestamo_usuario;
    private int perfil_usuario;
    private int prestamo_libro;
    private int prestamo_sede;
    private String nombre_libro;
    private String demanda_libro;
    private int prestamo_funcionario;
    private int diasAtraso;
    private int cantReno;
    private DatosPrestamo dbPrestamo;
    private Date fechaEntrega;
    private int diasAgregarReno;

    /**
     *
     * @param idPrestamo
     * @param prestamo_usuario
     * @param perfil_usuario
     * @param prestamo_libro
     * @param nombre_libro
     * @param demanda_libro
     * @param prestamo_funcionario
     * @param diasAtraso
     * @param dbPrestamo
     */
    public Prestamo(int idPrestamo, int prestamo_usuario, int perfil_usuario, int prestamo_libro, String nombre_libro, String demanda_libro, int prestamo_funcionario, int diasAtraso, DatosPrestamo dbPrestamo) {
        this.idPrestamo = idPrestamo;
        this.prestamo_usuario = prestamo_usuario;
        this.perfil_usuario = perfil_usuario;
        this.prestamo_libro = prestamo_libro;
        this.nombre_libro = nombre_libro;
        this.demanda_libro = demanda_libro;
        this.prestamo_funcionario = prestamo_funcionario;
        this.diasAtraso = diasAtraso;
        this.dbPrestamo = dbPrestamo;
    }

    /**
     *
     * @param idPrestamo
     * @throws Exception
     */
    public Prestamo(int idPrestamo) throws Exception {
        this.idPrestamo = idPrestamo;
        this.dbPrestamo = new DatosPrestamo();
    }

    /**
     *
     * @throws Exception
     */
    public Prestamo() throws Exception {
        this.dbPrestamo = new DatosPrestamo();
    }

    /**
     *
     * @return @throws SQLException
     * @throws Exception
     */
    public int obtenerDatos() throws SQLException, Exception {
        if (this.getDbPrestamo().obtenerDatos(this.getIdPrestamo())) {
            this.datosaNegocio();
            if (this.getDiasAtraso() <= 0) {
                //Camino para Perfil de Alumno
                if (this.getPerfil_usuario() == 4) {
                    if (this.getCantReno() == 1 && this.getDemanda_libro().equals("Alta")) {
                        return 2;
                    } else if (this.getCantReno() == 2 && this.getDemanda_libro().equals("Normal")) {
                        return 3;
                    } else if (this.getCantReno() == 0 && this.getDemanda_libro().equals("Alta")) {
                        this.setDiasAgregarReno(2);
                        return 4;
                    } else if (this.getCantReno() < 2 && this.getDemanda_libro().equals("Normal")) {
                        this.setDiasAgregarReno(5);
                        return 4;
                    }
                } //Camino para Perfil de Docente
                else if (this.getPerfil_usuario() == 3) {
                    if (this.getCantReno() == 2 && this.getDemanda_libro().equals("Alta")) {
                        return 2;
                    }
                    if (this.getCantReno() < 2 && this.getDemanda_libro().equals("Alta")) {
                        this.setDiasAgregarReno(3);
                        return 4;
                    } else if (this.getDemanda_libro().equals("Normal")) {
                        this.setDiasAgregarReno(10);
                        return 4;
                    }
                }
            } else {
                return 1;
            }
            return -99;
        } else {
            throw new Exception("Ha ocurrido un problema al buscar el prestamo solicitado.\nIntente nuevamente en unos segundos.");
        }
    }

    /**
     *
     * @throws SQLException
     */
    public void registrarRenovacion() throws SQLException {
        this.getDbPrestamo().registrarRenovacion(this.getIdPrestamo(), this.calcularDias(this.getFechaEntrega(),this.getDiasAgregarReno()));
    }

    /**
     *
     * @throws SQLException
     */
    public void registrarDevolución() throws SQLException {
        this.getDbPrestamo().setIdPrestamo(this.getIdPrestamo());
        this.getDbPrestamo().registrarDevolucion();
    }

    void registrarDevoluciónMultada(int multa) throws SQLException {
        this.getDbPrestamo().setIdPrestamo(this.getIdPrestamo());
        this.getDbPrestamo().registrarDevolucionMultada(multa);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public int registrarPrestamo() throws Exception {
        this.dbPrestamo.setPrestamo_usuario(this.getPrestamo_usuario());
        this.dbPrestamo.setPrestamo_libro(this.getPrestamo_libro());
        this.dbPrestamo.setPrestamo_sede(this.getPrestamo_sede());
        this.dbPrestamo.setDemanda_libro(this.getDemanda_libro());
        this.dbPrestamo.setPrestamo_funcionario(this.getPrestamo_funcionario());
        //Calculo de fecha a registrar de acuerdo a demanda y perfil del Usuario al que se le prestara el libro
        Date fechaDB = null;
        Date ahora = new java.sql.Date(new java.util.Date().getTime());
        if (this.getPerfil_usuario() == 4) {
            if (this.getDemanda_libro().equals("Alta")) {
                fechaDB = this.calcularDias(ahora, 2);
            } else if (this.getDemanda_libro().equals("Normal")) {
                fechaDB = this.calcularDias(ahora, 5);
            }
        } //Camino para Perfil de Docente
        else if (this.getPerfil_usuario() == 3) {
            if ( this.getDemanda_libro().equals("Alta")) {
               fechaDB = this.calcularDias(ahora, 3);
            }
            else if (this.getDemanda_libro().equals("Normal")) {
                fechaDB = this.calcularDias(ahora, 10);
            }
        }
        return this.dbPrestamo.registrarPrestamo(fechaDB);
    }

    /**
     *
     * @return @throws SQLException
     */
    public String nombreTexto() throws SQLException {
        this.getDbPrestamo().setIdPrestamo(this.getIdPrestamo());
        this.getDbPrestamo().obtenerDatos(this.getIdPrestamo());
        return this.getDbPrestamo().getNombre_libro();
    }

    private void datosaNegocio() {
        this.setPrestamo_usuario(this.getDbPrestamo().getPrestamo_usuario());
        this.setPerfil_usuario(this.getDbPrestamo().getPerfil_usuario());
        this.setPrestamo_libro(this.getDbPrestamo().getPrestamo_libro());
        this.setNombre_libro(this.getDbPrestamo().getNombre_libro());
        this.setDemanda_libro(this.getDbPrestamo().getDemanda_libro());
        this.setPrestamo_funcionario(this.getDbPrestamo().getPrestamo_funcionario());
        this.setDiasAtraso(this.getDbPrestamo().getDiasAtraso());
        this.setCantReno(this.getDbPrestamo().getCantReno());
        this.setFechaEntrega(this.getDbPrestamo().getFecha_entrega());
    }

    private Date calcularDias(Date fechaEntrega, int diasAgregar) {
        int agregarDias = 1;
        Calendar fechaRenovadaCal = Calendar.getInstance();
        fechaRenovadaCal.setTime(fechaEntrega);
        while (agregarDias < diasAgregar) {
            fechaRenovadaCal.add(Calendar.DAY_OF_MONTH, 1);
            switch (fechaRenovadaCal.get(Calendar.DAY_OF_MONTH)) {
                case Calendar.SATURDAY:
                    break;
                case Calendar.SUNDAY:
                    break;
                default:
                    agregarDias++;
                    break;
            }
        }
        Date fechaRenovada = new java.sql.Date(fechaRenovadaCal.getTimeInMillis());
        return fechaRenovada;
    }

    /**
     * @return the idPrestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return the prestamo_usuario
     */
    public int getPrestamo_usuario() {
        return prestamo_usuario;
    }

    /**
     * @param prestamo_usuario the prestamo_usuario to set
     */
    public void setPrestamo_usuario(int prestamo_usuario) {
        this.prestamo_usuario = prestamo_usuario;
    }

    /**
     * @return the perfil_usuario
     */
    public int getPerfil_usuario() {
        return perfil_usuario;
    }

    /**
     * @param perfil_usuario the perfil_usuario to set
     */
    public void setPerfil_usuario(int perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    /**
     * @return the prestamo_libro
     */
    public int getPrestamo_libro() {
        return prestamo_libro;
    }

    /**
     * @param prestamo_libro the prestamo_libro to set
     */
    public void setPrestamo_libro(int prestamo_libro) {
        this.prestamo_libro = prestamo_libro;
    }

    /**
     * @return the nombre_libro
     */
    public String getNombre_libro() {
        return nombre_libro;
    }

    /**
     * @param nombre_libro the nombre_libro to set
     */
    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    /**
     * @return the demanda_libro
     */
    public String getDemanda_libro() {
        return demanda_libro;
    }

    /**
     * @param demanda_libro the demanda_libro to set
     */
    public void setDemanda_libro(String demanda_libro) {
        this.demanda_libro = demanda_libro;
    }

    /**
     * @return the prestamo_funcionario
     */
    public int getPrestamo_funcionario() {
        return prestamo_funcionario;
    }

    /**
     * @param prestamo_funcionario the prestamo_funcionario to set
     */
    public void setPrestamo_funcionario(int prestamo_funcionario) {
        this.prestamo_funcionario = prestamo_funcionario;
    }

    /**
     * @return the diasAtraso
     */
    public int getDiasAtraso() {
        return diasAtraso;
    }

    /**
     * @param diasAtraso the diasAtraso to set
     */
    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    /**
     * @return the dbPrestamo
     */
    public DatosPrestamo getDbPrestamo() {
        return dbPrestamo;
    }

    /**
     * @param dbPrestamo the dbPrestamo to set
     */
    public void setDbPrestamo(DatosPrestamo dbPrestamo) {
        this.dbPrestamo = dbPrestamo;
    }

    /**
     * @return the fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @return the diasAgregarReno
     */
    public int getDiasAgregarReno() {
        return diasAgregarReno;
    }

    /**
     * @param diasAgregarReno the diasAgregarReno to set
     */
    public void setDiasAgregarReno(int diasAgregarReno) {
        this.diasAgregarReno = diasAgregarReno;
    }

    /**
     * @return the prestamo_sede
     */
    public int getPrestamo_sede() {
        return prestamo_sede;
    }

    /**
     * @param prestamo_sede the prestamo_sede to set
     */
    public void setPrestamo_sede(int prestamo_sede) {
        this.prestamo_sede = prestamo_sede;
    }

}
