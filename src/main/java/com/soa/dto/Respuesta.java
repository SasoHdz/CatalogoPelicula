package com.soa.dto;


import com.google.gson.Gson;

/**
 * Clase que modela la informacion resumida de una persona.
 */
public class Respuesta {

    /** Mensaje de respuesta. */
    private String message;

    private Boolean status;
    
    
    
    public Respuesta(String message, Boolean status) {
        super();
        this.message = message;
        this.status = status;
    }
    
    public Respuesta() {}
 
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
   
}
