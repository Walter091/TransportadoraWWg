package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.service.ServicePessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    
    @Autowired
    private ServicePessoa servico;
    
    @GetMapping("/index")
    public String index(){
        return "Hello world";
    }
    
    @GetMapping("/buscar")
    public Iterable buscar(){
        return servico.buscarTodos();
    }

    @PostMapping("/persistir")
    public void salvar(Pessoa pessoa){
        servico.salvar(pessoa);
    }
}
