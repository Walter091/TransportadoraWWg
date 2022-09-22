package br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.nucleo.utils.filesUtils.GerarRelatorioJasper;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

public class CreateReports {
    
    // Usar esse atributo para popular os parametros...
    private RelatorioBaseLancamento dataSources;

    public CreateReports(RelatorioBaseLancamento dataSource) {
        this.dataSources = dataSource;
    }

    public CreateReports() {}
    
    public void criarRelatorio(List<Lancamento> dataSource, OutputStream saida) {
        GerarRelatorioJasper report = new GerarRelatorioJasper();
        try {
            report.gerarRelatorio(dataSource, saida);
        } catch (JRException ex) {
            Logger.getLogger(CreateReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
