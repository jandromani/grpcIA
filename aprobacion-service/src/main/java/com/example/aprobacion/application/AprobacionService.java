package com.example.aprobacion.application;

import com.example.aprobacion.domain.rules.AprobacionRuleEngine;
import com.example.aprobacion.persistence.RuleEntity;
import com.example.aprobacion.persistence.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprobacionService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private AprobacionRuleEngine ruleEngine;

    public boolean evaluarSolicitud(double monto) {
        List<RuleEntity> reglas = ruleRepository.findAll();
        return ruleEngine.evaluar(reglas, monto);
    }

    public RuleEntity crearRegla(String descripcion, String expresion) {
        return ruleRepository.save(new RuleEntity(descripcion, expresion));
    }

    public void eliminarRegla(Long id) {
        ruleRepository.deleteById(id);
    }
}
