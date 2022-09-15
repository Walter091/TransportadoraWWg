package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceProduto;
import br.com.gw_sistemas.transportadorawwg.nucleo.base.RetornoRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProdutoController {

    @Autowired
    private ServiceProduto serviceProduto;

    @GetMapping("/transportadora/produtos")
    public Iterable getAll() {
        return serviceProduto.buscarTodos();
    }

    @GetMapping("/transportadora/produtos/{id}")
    public Produto get(@PathVariable("id") Long id) {
        return serviceProduto.buscarTodosByID(id);
    }

    @PostMapping("/transportadora/produtos")
    public RetornoRequisicao post(@RequestBody Produto produto) {
        return serviceProduto.salvar(produto);
    }

    @PutMapping("/transportadora/produtos")
    public String put(@RequestBody Produto produto) {
        serviceProduto.alterar(produto);

        return "";
    }

    @DeleteMapping("/transportadora/produtos")
    public String delete(@RequestBody Produto produto) {
        serviceProduto.deletar(produto, produto.getId());

        return "";
    }
}
