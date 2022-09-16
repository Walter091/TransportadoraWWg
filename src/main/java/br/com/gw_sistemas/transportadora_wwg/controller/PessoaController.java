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

@RestController("/Transportadora/Opcoes")
public class PessoaController {

    @Autowired
    private ServicePessoa servicoPessoa;

    @GetMapping("/Clientes")
    public Iterable buscar() {
        return servicoPessoa.buscarTodos();
    }
    
        @GetMapping("/Clientes/{id}")
    public Pessoa buscarTodosByID(@PathVariable("id") Long id) {
        return servicoPessoa.buscarTodosByID(id);
    }
    
    @GetMapping("/Clientes/Cadastrar")
    public String formCadastro() {
        return "";
    }
    
    @PostMapping("/Clientes/Cadastrar/Salvar")
    public void salvar(Pessoa pessoa) {
        servicoPessoa.salvar(pessoa);
    }
    
    @PutMapping("/Clientes/Editar")
    public String alterar() {
        return "";
    }

    @DeleteMapping("/Clientes/Delete")
    public String delete() {
        return "";
    }
}
