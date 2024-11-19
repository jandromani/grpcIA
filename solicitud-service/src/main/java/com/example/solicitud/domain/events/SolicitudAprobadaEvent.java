package com.example.solicitud.domain.events;

public class SolicitudAprobadaEvent {

    private Long solicitudId;
    private String solicitante;

    public SolicitudAprobadaEvent(Long solicitudId, String solicitante) {
        this.solicitudId = solicitudId;
        this.solicitante = solicitante;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
}
