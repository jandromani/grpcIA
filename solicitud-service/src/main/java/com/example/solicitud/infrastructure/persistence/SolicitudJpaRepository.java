package com.example.solicitud.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudJpaRepository extends JpaRepository<SolicitudEntity, Long> {

	SolicitudEntity save(SolicitudEntity solicitud);
}
