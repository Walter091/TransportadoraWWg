package br.com.gw_sistemas.transportadora_wwg.nucleo.utils.filesUtils;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GerarRelatorioJasper extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    private ByteArrayOutputStream baos;
    public void gerarRelatorio(List<Lancamento> lista, OutputStream saida) throws JRException {
          JasperDesign desenho = JRXmlLoader.load("/home/walter/Documentos/teste/transportador-wwg/src/main/resources/reports/relatorioBaseLancamento.jrxml");
          JasperReport report = null;
          baos = new ByteArrayOutputStream();
          
        try {
            report = JasperCompileManager.compileReport(desenho);
        } catch (JRException ex) {
            Logger.getLogger(GerarRelatorioJasper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, Object> parametros = new HashMap<>();
        for (Lancamento lanc : lista) {
            parametros.put("ID", lanc.getId());
            parametros.put("DATA_SAIDA", lanc.getDataSaida());
            parametros.put("DATA_ENTREGA", lanc.getDataEntrega());
            parametros.put("STATUS", lanc.getStatus());
            parametros.put("REMETENTE", lanc.getRemetente().getNome());
            parametros.put("DESTINATARIO", lanc.getDestinatario().getNome());
            parametros.put("PRODUTO", lanc.getProduto().getNome());
        }
        
        JasperPrint impressao = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(lista));
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING.JASPER_PRINT, impressao);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

        exporter.exportReport();
                 
    }
    

}
