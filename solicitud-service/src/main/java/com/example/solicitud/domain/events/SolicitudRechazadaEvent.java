package com.example.solicitud.domain.events;

public class SolicitudRechazadaEvent {

    private Long solicitudId;
    private String motivo;

    public SolicitudRechazadaEvent(Long solicitudId, String motivo) {
        this.solicitudId = solicitudId;
        this.motivo = motivo;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
