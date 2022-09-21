package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceLancamento;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@RestController()
public class LancamentoController {

    @Autowired
    private ServiceLancamento serviceLancamento;

    @GetMapping("/transportadora-wwg/opcoes/lancamentos")
    public ModelAndView buscar() {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.buscarTodos();
        
        pgRalatorios.addObject("listLancamentos", todosLancamentos);
        return pgRalatorios;
    }

    @GetMapping("/transportadora-wwg/opcoes/lancamentos/{id}")
    public ModelAndView buscarTodosByID(@PathVariable("id") Long id) {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.buscarTodosByID(id);
        
        pgRalatorios.addObject("todosLancamentosFiltrados", todosLancamentos);
        return pgRalatorios;
    }
    
    @GetMapping("/transportadora-wwg/opcoes/lancamentos/cadastrar")
    public ModelAndView formCadastro(@ModelAttribute("lancamento") Lancamento lancamento, Model model) {  
        ModelAndView pgLacamento =new ModelAndView("FormLancamentos");
        pgLacamento.addObject("lancamento", new Lancamento());
        pgLacamento.addObject("listPessoas", serviceLancamento.getListPessoas());
        pgLacamento.addObject("listProdutos", serviceLancamento.getListProdutos());        
        return pgLacamento;
    }

    @PostMapping("/transportadora-wwg/opcoes/lancamentos/cadastrar/salvar")
    public RedirectView salvar(@ModelAttribute("lancamento") Lancamento lancamento) {
        if(serviceLancamento.salvar(lancamento)) {
            return new RedirectView("/transportadora-wwg/opcoes/lancamentos");
        }else {
            return new RedirectView("");
        }
    }

    @PutMapping("/transportadora-wwg/opcoes/lancamentos/editar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        Lancamento obj = serviceLancamento.buscarTodosByID(id);
        serviceLancamento.alterar(obj);
        ModelAndView pgFormLancamentos = new ModelAndView("FormLancamentos");
        return pgFormLancamentos;
    }

    @DeleteMapping("/transportadora-wwg/opcoes/lancamentos/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        Lancamento obj = serviceLancamento.buscarTodosByID(id);
        serviceLancamento.deletar(obj, obj.getId());
        return new RedirectView("/transportadora-wwg/opcoes/lancamentos");
    }
    
    @GetMapping("/transportadora-wwg/lancamento/exportarPdf")
    public void exportarPdf(HttpServletResponse response) throws IOException {        
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.buscarTodos();
        serviceLancamento.gerarRelatorio(todosLancamentos, response.getOutputStream());
    }
    
}
    