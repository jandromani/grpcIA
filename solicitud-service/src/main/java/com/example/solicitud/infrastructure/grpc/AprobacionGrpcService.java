package com.example.solicitud.infrastructure.grpc;

import com.example.grpc.AprobacionServiceGrpc;
import com.example.grpc.AprobacionServiceProto;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class AprobacionGrpcService extends AprobacionServiceGrpc.AprobacionServiceImplBase {

    @Override
    public void validarSolicitud(AprobacionServiceProto.ValidarSolicitudRequest request,
                                 StreamObserver<AprobacionServiceProto.ValidarSolicitudResponse> responseObserver) {
        boolean resultado = request.getMonto() > 5000; // Ejemplo: Aprobación basada en monto
        AprobacionServiceProto.ValidarSolicitudResponse response = AprobacionServiceProto.ValidarSolicitudResponse
                .newBuilder()
                .setAprobado(resultado)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
