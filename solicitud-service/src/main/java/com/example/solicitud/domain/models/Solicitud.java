package com.example.solicitud.domain.models;

public class Solicitud {

    private Long id;
    private String solicitante;
    private String detalle;
    private double monto;
    private String estado;

    public Solicitud() {}

    public Solicitud(Long id, String solicitante, String detalle, double monto, String estado) {
        this.id = id;
        this.solicitante = solicitante;
        this.detalle = detalle;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
