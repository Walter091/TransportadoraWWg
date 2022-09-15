package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.service.ServicePessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @Autowired
    private ServicePessoa servico;

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("home/index");
    }

    @GetMapping("/buscar")
    public Iterable buscar() {
        return servico.buscarTodos();
    }

    @PostMapping("/persistir")
    public void salvar(Pessoa pessoa) {
        servico.salvar(pessoa);
    }

    @GetMapping("/home")
    public String entrarTelaHome() {
        // Criar a pagina html e retornar o caminho aqui...
        return null;
    }

    @GetMapping("/cadastro")
    public String entrarTelaCadastro() {
        // Criar a pagina html e retornar o caminho aqui...
        return null;
    }

    @GetMapping("/relatorios")
    public String entrarTelaRelatorios() {
        // Criar a pagina html e retornar o caminho aqui...
        return null;
    }

}
