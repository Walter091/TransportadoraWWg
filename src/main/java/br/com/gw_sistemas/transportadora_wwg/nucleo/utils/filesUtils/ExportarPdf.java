package br.com.gw_sistemas.transportadora_wwg.nucleo.utils.filesUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;  

public class ExportarPdf {
            
    public static Document criarArquivoPdf(File caminho, String nomeArquivo) throws DocumentException{
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(caminho + "/" + nomeArquivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportarPdf.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Report Criado", font);

        document.add(chunk);
        document.close();    
        
        return document;
    }
    
    public static File criarPastaParaRelatorios(String caminho, String nomePasta){
      String path = caminho + nomePasta;   
      File file = new File(path);     
      file.mkdirs();
      
      return file;
    }
    
}
