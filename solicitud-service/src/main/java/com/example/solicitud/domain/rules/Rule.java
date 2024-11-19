package com.example.solicitud.domain.rules;

import javax.persistence.*;

@Entity
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String expresion; // Por ejemplo: "monto < 5000"

    public Rule() {}

    public Rule(String descripcion, String expresion) {
        this.descripcion = descripcion;
        this.expresion = expresion;
    }

    // Getters y setters
}
