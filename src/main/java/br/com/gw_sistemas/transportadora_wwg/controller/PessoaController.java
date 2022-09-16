package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.service.ServicePessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PessoaController {

    @Autowired
    private ServicePessoa servicoPessoa;

    @GetMapping("/transportadora-wwg/opcoes/clientes")
    public Iterable buscar() {
        return servicoPessoa.buscarTodos();
    }
    
        @GetMapping("/transportadora-wwg/opcoes/clientes/{id}")
    public Pessoa buscarTodosByID(@PathVariable("id") Long id) {
        return servicoPessoa.buscarTodosByID(id);
    }
    
    @GetMapping("/transportadora-wwg/opcoes/clientes/cadastrar")
    public String formCadastro() {
        return "";
    }
    
    @PostMapping("/transportadora-wwg/opcoes/clientes/cadastrar/salvar")
    public void salvar(Pessoa pessoa) {
        servicoPessoa.salvar(pessoa);
    }
    
    @PutMapping("/transportadora-wwg/opcoes/Clientes/Editar")
    public String alterar() {
        return "";
    }

    @DeleteMapping("/transportadora-wwg/opcoes/Clientes/Delete")
    public String delete() {
        return "";
    }
}
