package br.com.gw_sistemas.transportadora_wwg.testeServicos;

import java.math.BigDecimal;

public class BonusSalario {
    
    public BigDecimal calcularBonus(BigDecimal salario){
        BigDecimal bonus = salario.multiply(new BigDecimal("10"));
        if (salario.compareTo(new BigDecimal("1000")) > 0) {
            bonus = BigDecimal.ZERO;
        }
        return bonus;
        
    }
    
}
