package br.com.gw_sistemas.transportadora_wwg.nucleo.utils.filesUtils;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class GerarRelatorioJasper {

    public void gerarRelatorio(List<Lancamento> lista) throws JRException {
          InputStream fonte = GerarRelatorioJasper.class.getResourceAsStream("/reports/relatorioBaseLancamento.jrxml");
          JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(fonte);
        } catch (JRException ex) {
            Logger.getLogger(GerarRelatorioJasper.class.getName()).log(Level.SEVERE, null, ex);
        }
          JasperPrint impressao = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
          JasperViewer.viewReport(impressao, false);
        
    }
}
