/**
 * 
 */
package com.soa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Pelicula;
import com.soa.dto.Respuesta;
import com.soa.dto.Titulo;

/**
 * Capa de acceso a datos.
 */
@Repository
public class CatalogoDao {

    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Verifica que la tarjeta, cvv, fechaExp existen y coinciden los datos
     * @param usuario
     * @return
     */
    public Float find(String titulo, Integer time) {
      Float resp;
      
      List<Pelicula> peliculas = jdbcTemplate.query("SELECT id, titulo, noDisp, noOcup, duracion, costo FROM Peliculas WHERE titulo = '"+titulo+"'", new BeanPropertyRowMapper<Pelicula>(Pelicula.class));
      
      if(peliculas.get(0).getId()>0) {
          if(this.checkDisp(peliculas.get(0).getNoDisp(), peliculas.get(0).getNoOcup())) {
              resp = this.costoRenta(peliculas.get(0).getCosto(), peliculas.get(0).getDuracion(), time);
          }
          else resp = -1f;
      }
      else resp = -1f;
     
     return resp;
    }
    
    public Float costoRenta(Float costo, Integer duracion, Integer time) {
       return (time*costo/duracion);
    }
    
    public Boolean checkDisp(Integer disp, Integer ocup) {                
        return disp>ocup;
    }
}
