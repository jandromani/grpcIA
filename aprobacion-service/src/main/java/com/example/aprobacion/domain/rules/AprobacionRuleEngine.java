package com.example.aprobacion.domain.rules;

import com.example.aprobacion.persistence.RuleEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AprobacionRuleEngine {

    public boolean evaluar(List<RuleEntity> reglas, double monto) {
        for (RuleEntity regla : reglas) {
            if (!evaluarRegla(regla, monto)) {
                return false; // Si una regla no se cumple, la solicitud no se aprueba
            }
        }
        return true; // Si todas las reglas se cumplen, la solicitud se aprueba
    }

    private boolean evaluarRegla(RuleEntity regla, double monto) {
        // Lógica simple de ejemplo: si la regla incluye "monto > X", validar el monto
        if (regla.getExpresion().contains("monto >")) {
            String[] partes = regla.getExpresion().split(">");
            double limite = Double.parseDouble(partes[1].trim());
            return monto > limite;
        }
        // Otras reglas personalizadas pueden añadirse aquí
        return true;
    }
}
