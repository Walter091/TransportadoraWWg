package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceLancamento;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import static org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import static org.springframework.web.servlet.function.RequestPredicates.headers;
import org.springframework.web.servlet.view.RedirectView;

@RestController()
public class LancamentoController {

    @Autowired
    private ServiceLancamento serviceLancamento;
    
    private StatusFormularioEnum statusFormulario;
    
    @GetMapping("/transportadora-wwg/opcoes/lancamentos")
    public ModelAndView buscar() {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        
        pgRalatorios.addObject("listLancamentos", serviceLancamento.getListLancamentos());
        return pgRalatorios;
    }

    @GetMapping("/transportadora-wwg/opcoes/lancamentos/{id}")
    public ModelAndView buscarTodosByID(@PathVariable("id") Long id) {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        
        pgRalatorios.addObject("todosLancamentosFiltrados", serviceLancamento.buscarTodosByID(id));
        return pgRalatorios;
    }
    
    @GetMapping("/transportadora-wwg/opcoes/lancamentos/cadastrar")
    public ModelAndView formCadastro(@ModelAttribute("lancamento") Lancamento lancamento, Model model) {  
        ModelAndView pgLacamento =new ModelAndView("FormLancamentos");
        pgLacamento.addObject("lancamento", new Lancamento());
        pgLacamento.addObject("listPessoas", serviceLancamento.getListPessoas());
        pgLacamento.addObject("listProdutos", serviceLancamento.getListProdutos()); 
        
        if (statusFormulario == StatusFormularioEnum.EM_ERRO) {
            pgLacamento.addObject("msgError", serviceLancamento.getERRO());        
        }
        return pgLacamento;
    }

    @PostMapping("/transportadora-wwg/opcoes/lancamentos/cadastrar/salvar")
    public RedirectView salvar(@ModelAttribute("lancamento") Lancamento lancamento) {
        if (statusFormulario == StatusFormularioEnum.ALTERAR) {
            serviceLancamento.alterar(lancamento);
            return new RedirectView("/transportadora-wwg/opcoes/lancamentos");
        } else {
            if (serviceLancamento.salvar(lancamento)) {
                return new RedirectView("/transportadora-wwg/opcoes/lancamentos");
            } else {
                statusFormulario = StatusFormularioEnum.EM_ERRO;
                return new RedirectView("/transportadora-wwg/opcoes/lancamentos/cadastrar");
            }
        }
    }
    
    @GetMapping("/transportadora-wwg/opcoes/lancamentos/editar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        statusFormulario = StatusFormularioEnum.ALTERAR;
        Optional<Lancamento> obj = serviceLancamento.buscarPorId(id);

        ModelAndView pgFormLancamentos = new ModelAndView("FormAlterarLancamentos");
        pgFormLancamentos.addObject("lancamento", obj.get());
        pgFormLancamentos.addObject("listRemetente", obj.get().getRemetente());
        pgFormLancamentos.addObject("listDestinatario", obj.get().getDestinatario());
        pgFormLancamentos.addObject("listProdutos", obj.get().getProduto());        

        return pgFormLancamentos;
    }

    @GetMapping("/transportadora-wwg/opcoes/lancamentos/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        Optional<Lancamento> obj = serviceLancamento.buscarPorId(id);
        serviceLancamento.deletar(obj.get(), obj.get().getId());
        return new RedirectView("/transportadora-wwg/opcoes/lancamentos");
    }
    
    // ---------------------------------------------------------------------------------------------------------
    
    @GetMapping("/transportadora-wwg/opcoes/lancamentos/relatorios")
    public ResponseEntity<byte[]> exportarPdf() throws JRException, IOException  {        
        byte data[] = serviceLancamento.exportReport();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
       
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

    }
   

}
    