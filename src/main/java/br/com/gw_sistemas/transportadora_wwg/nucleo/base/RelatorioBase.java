package br.com.gw_sistemas.transportadora_wwg.nucleo.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.util.ResourceUtils;

public class RelatorioBase {
    
     public static byte[] exportReport(List<T> lista, String nomeArquivoJrxmlSemExtensao, String nomeArquivoPdfSemExtensao) throws FileNotFoundException, JRException {
        File file = ResourceUtils.getFile("classpath:" + nomeArquivoJrxmlSemExtensao + ".jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivoPdfSemExtensao + ".pdf");
        
        byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

        return data;
    }
}
