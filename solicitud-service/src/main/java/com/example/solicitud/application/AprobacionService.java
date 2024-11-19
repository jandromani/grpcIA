package com.example.solicitud.application;

import org.springframework.stereotype.Service;

@Service
public class AprobacionService {

    public boolean validarMonto(double monto) {
        return monto > 5000; // Ejemplo de validación
    }
}
