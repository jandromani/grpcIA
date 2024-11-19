package com.example.solicitud.infrastructure.grpc;

import com.example.grpc.SolicitudServiceGrpc;
import com.example.grpc.SolicitudServiceProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.grpc.stub.StreamObserver;

@Service
public class SolicitudGrpcService extends SolicitudServiceGrpc.SolicitudServiceImplBase {

    @Autowired
    private com.example.solicitud.application.SolicitudService solicitudService;

    @Override
    public void obtenerSolicitud(SolicitudServiceProto.ObtenerSolicitudRequest request,
                                 StreamObserver<SolicitudServiceProto.ObtenerSolicitudResponse> responseObserver) {
        SolicitudServiceProto.ObtenerSolicitudResponse response = SolicitudServiceProto.ObtenerSolicitudResponse
                .newBuilder()
                .setId(request.getId())
                .setSolicitante("Juan Pérez") // Simulación de datos
                .setMonto(10000)
                .setEstado("APROBADA")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
