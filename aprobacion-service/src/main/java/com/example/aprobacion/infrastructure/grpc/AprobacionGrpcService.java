package com.example.aprobacion.infrastructure.grpc;

import com.example.grpc.AprobacionServiceGrpc;
import com.example.grpc.AprobacionServiceProto;
import com.example.aprobacion.application.AprobacionService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AprobacionGrpcService extends AprobacionServiceGrpc.AprobacionServiceImplBase {

    @Autowired
    private AprobacionService aprobacionService;

    @Override
    public void evaluarSolicitud(AprobacionServiceProto.EvaluarSolicitudRequest request,
                                 StreamObserver<AprobacionServiceProto.EvaluarSolicitudResponse> responseObserver) {
        boolean aprobado = aprobacionService.evaluarSolicitud(request.getMonto());
        AprobacionServiceProto.EvaluarSolicitudResponse response = AprobacionServiceProto.EvaluarSolicitudResponse
                .newBuilder()
                .setAprobado(aprobado)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
