package com.example.solicitud.infrastructure.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "solicitud-events", groupId = "solicitud-group")
    public void consumirMensaje(String mensaje) {
        System.out.println("Mensaje recibido: " + mensaje);
    }
}
