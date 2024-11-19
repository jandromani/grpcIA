package com.example.solicitud.application;

import com.example.solicitud.infrastructure.persistence.SolicitudEntity;
import com.example.solicitud.infrastructure.persistence.SolicitudJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudJpaRepository solicitudJpaRepository;

    public SolicitudEntity crearSolicitud(SolicitudEntity solicitud) {
        return solicitudJpaRepository.save(solicitud);
    }

    public List<SolicitudEntity> obtenerTodas() {
        return solicitudJpaRepository.findAll();
    }

    public SolicitudEntity cambiarEstado(Long id, String nuevoEstado) {
        SolicitudEntity solicitud = solicitudJpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        solicitud.setEstado(nuevoEstado);
        return solicitudJpaRepository.save(solicitud);
    }
}
