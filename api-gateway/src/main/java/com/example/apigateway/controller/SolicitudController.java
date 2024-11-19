package com.example.apigateway.controller;

import com.example.apigateway.dto.SolicitudDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private RestTemplate restTemplate;

    private final String SOLICITUD_SERVICE_URL = "http://localhost:8081/api/solicitudes";

    @PostMapping
    public ResponseEntity<SolicitudDTO> crearSolicitud(@RequestBody SolicitudDTO solicitudDTO) {
        ResponseEntity<SolicitudDTO> response = restTemplate.postForEntity(
                SOLICITUD_SERVICE_URL, solicitudDTO, SolicitudDTO.class);
        return response;
    }

    @GetMapping
    public ResponseEntity<List> obtenerSolicitudes() {
        ResponseEntity<List> response = restTemplate.getForEntity(
                SOLICITUD_SERVICE_URL, List.class);
        return response;
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<SolicitudDTO> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        String url = SOLICITUD_SERVICE_URL + "/" + id + "/estado?estado=" + estado;
        restTemplate.put(url, null);
        ResponseEntity<SolicitudDTO> response = restTemplate.getForEntity(
                SOLICITUD_SERVICE_URL + "/" + id, SolicitudDTO.class);
        return response;
    }
}
