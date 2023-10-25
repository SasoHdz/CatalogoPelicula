/**
 * 
 */
package com.soa.dto;

/**
 * 
 */
public class Pelicula {
    
    private Integer id;
    private String titulo;
    private Integer noDisp;
    private Integer noOcup;
    private Integer duracion;
    private Float costo;
    
    public Pelicula(Integer id, String titulo, Integer noDisp, Integer noOcup, Integer duracion, Float costo) {
        this.id = id;
        this.titulo = titulo;
        this.noDisp = noDisp;
        this.noOcup = noOcup;
        this.duracion = duracion;
        this.costo = costo;
    }
    
    public Pelicula() {}
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getNoDisp() {
        return noDisp;
    }
    public void setNoDisp(Integer noDisp) {
        this.noDisp = noDisp;
    }
    public Integer getNoOcup() {
        return noOcup;
    }
    public void setNoOcup(Integer noOcup) {
        this.noOcup = noOcup;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public Float getCosto() {
        return costo;
    }
    public void setCosto(Float costo) {
        this.costo = costo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
