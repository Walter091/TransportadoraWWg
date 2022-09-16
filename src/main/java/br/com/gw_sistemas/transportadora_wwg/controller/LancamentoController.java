package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceLancamento;
import br.com.gw_sistemas.transportadorawwg.nucleo.base.RetornoRequisicao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class LancamentoController {

    @Autowired
    private ServiceLancamento serviceLancamento;

    @GetMapping("/transportadora-wwg/lancamentos")
    public ModelAndView buscar() {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.buscarTodos();
        
        pgRalatorios.addObject("todosLancamentos", todosLancamentos);
        return pgRalatorios;
    }

    @GetMapping("/transportadora-wwg/lancamentos/{id}")
    public ModelAndView buscarTodosByID(@PathVariable("id") Long id) {
        ModelAndView pgRalatorios = new ModelAndView("Relatorios");
        List<Lancamento> todosLancamentos = (List<Lancamento>) serviceLancamento.buscarTodosByID(id);
        
        pgRalatorios.addObject("todosLancamentosFiltrados", todosLancamentos);
        return pgRalatorios;
    }

    @GetMapping("/transportadora-wwg/opcoes/lancamentos/cadastrar")
    public String formCadastro() {
        return "";
    }

    @PostMapping("/transportadora-wwg/opcoes/lancamentos/cadastrar/salvar")
    public ModelAndView salvar(Lancamento lancamento) {
        return null;
    }

    @PutMapping("/transportadora-wwg/opcoes/lancamentos/editar")
    public String alterar() {
        return "";
    }

    @DeleteMapping("/transportadora-wwg/opcoes/lancamentos/delete")
    public String delete() {
        return "";
    }
}
