/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gw_sistemas.transportadora_wwg.testeServicos.BonusSalario;
import java.math.BigDecimal;
import static org.testng.Assert.*;

/**
 *
 * @author walter
 */
public class TesteBonusSalarial {
    
    public TesteBonusSalarial() {
        BonusSalario bonus = new BonusSalario();
        BigDecimal valor = bonus.calcularBonus(new BigDecimal("1000"));
        
        assertEquals(BigDecimal.ZERO, valor);
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
