package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceLancamento;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

@RestController()
public class LancamentoController {

    @Autowired
    private ServiceLancamento serviceLancamento;
    
    private StatusFormularioEnum statusFormulario;
    
    @GetMapping("/transportadora-wwg/opcoes/lancamentos")
    public ModelAndView buscar() {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.getListLancamentos();
        
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
        
    @GetMapping("/transportadora-wwg/lancamento/exportarPdf")
    public void exportarPdf(HttpServletResponse response) throws IOException {        
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.buscarTodos();
        serviceLancamento.gerarRelatorio(todosLancamentos, response.getOutputStream());
    }
    
}
    