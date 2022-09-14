package br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.nucleo.utils.filesUtils.GerarRelatorioJasper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

public class CreateReports implements itfcReport {
    
    // Usar esse atributo para popular os parametros...
    private RelatorioBaseLancamento dataSources;

    public CreateReports(RelatorioBaseLancamento dataSource) {
        this.dataSources = dataSource;
    }

    public CreateReports() {}
    
    @Override
    public void criarRelatorio(List<Lancamento> dataSource) {
        GerarRelatorioJasper report = new GerarRelatorioJasper();
        try {
            report.gerarRelatorio(dataSource);
        } catch (JRException ex) {
            Logger.getLogger(CreateReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exibirRelatorio() {
        // implementar...
    }

    @Override
    public void popularDataSource() {
        // implementar...
    }
    
    
}
