package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("transportadora")
class ProdutoController {
    
    @Autowired
    private ServiceProduto serviceProduto;
    
    @GetMapping("/produtos")
    public Iterable<Produto> getAll() {
        return serviceProduto.buscarTodos();
    }

    @GetMapping("/produto/{id}")
    public Produto get(@PathVariable("id") Long id) {
        return serviceProduto.buscarProduto(id);
    }

    @PostMapping("/produtos")
    public String post() {
        return "ADD PRODUTO";
    }

    @PutMapping("/produtos")
    public String put() {
        return "EDITAR PRODUTO";
    }

    @DeleteMapping
    public String delete() {
        return "DELETAR PRODUTO";
    }
}
