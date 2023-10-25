/**
 * 
 */
package com.soa.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.CatalogoDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Titulo;

/**
 * Clase para concatenación de datos personales.
 */
@Component
public class CatalogoBusiness {
    /** Objeto de acceso a datos. */
    @Autowired
    private CatalogoDao catDao;
    
    public Float checkData(String titulo, Integer time) {

        Float resp = -1f;
       
         try {
              resp = catDao.find(titulo,time);     
         }catch(Exception e) {
             e.printStackTrace();
         }
         
         return resp;
    }


   
}
