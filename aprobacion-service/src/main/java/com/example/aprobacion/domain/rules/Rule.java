package com.example.aprobacion.domain.rules;

public class Rule {

    private String descripcion;
    private String expresion;

    public Rule(String descripcion, String expresion) {
        this.descripcion = descripcion;
        this.expresion = expresion;
    }

    // Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
