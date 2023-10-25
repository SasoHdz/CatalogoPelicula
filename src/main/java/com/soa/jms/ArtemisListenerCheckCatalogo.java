/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.CatalogoBusiness;
import com.soa.dto.DatosRenta;
import com.soa.dto.Respuesta;
import com.soa.dto.Titulo;

/**
 * Class for receiving messages in an artemis queue.
 */
@Component
public class ArtemisListenerCheckCatalogo {
    
    @Autowired
    private CatalogoBusiness business;

    @Autowired
    private JmsSender sender;

    /** Nombre de la cola de respuesta del microservicio. */
    @Value("${tarjeta.queue.name.in}")
    private String outQueueName;

    @JmsListener(destination = "${catalogo.queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s",
                message));
        Gson gson = new Gson();
        DatosRenta data = gson.fromJson(message, DatosRenta.class);
        Float costo = business.checkData(data.getTitulo(),data.getTiempo());
        if(costo<0) {
            data.setStatus(false);
        }
        else {
            data.setStatus(true);
            data.setCostoRenta(costo);
        }
        System.out.println("Resultado de consulta: "+costo);
        try {
            sender.sendMessage(data.toString(), outQueueName); //Pasa mensaje a siguiente cola
            System.out.println(String.format("Mensaje enviado: %s", 
                    data.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
