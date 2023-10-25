package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion de un usuario.
 */
public class Titulo {
    
    private String titulo;
    private Integer time;
  
  
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }


    public String getTitulo() {
        return titulo.toUpperCase();
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Integer getTime() {
        return time;
    }


    public void setTime(Integer time) {
        this.time = time;
    }
   
}
