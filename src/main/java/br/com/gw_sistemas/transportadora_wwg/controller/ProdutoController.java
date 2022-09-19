package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceProduto;
import br.com.gw_sistemas.transportadorawwg.nucleo.base.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
class ProdutoController {

    @Autowired
    private ServiceProduto serviceProduto;

    @GetMapping("/transportadora-wwg/opcoes/produtos")
    public Iterable buscarTodos() {
        return serviceProduto.buscarTodos();
    }

    @GetMapping("/transportadora-wwg/opcoes/produtos/{id}")
    public Produto buscarTodosByID(@PathVariable("id") Long id) {
        return serviceProduto.buscarTodosByID(id);
    }

    @GetMapping("/transportadora-wwg/opcoes/produtos/cadastrar")
    public String formCadastro(@RequestBody Produto produto) {
        return "";
    }

    @PostMapping("/transportadora-wwg/opcoes/produtos/cadastrar/salvar")
    public Requisicao salvar(@RequestBody Produto produto) {
        return serviceProduto.salvar(produto);
    }

    @PutMapping("/transportadora-wwg/opcoes/produtos/dditar")
    public String alterar(@RequestBody Produto produto) {
        serviceProduto.alterar(produto);
        return "";
    }

    @DeleteMapping("/transportadora-wwg/opcoes/produtos/delete")
    public String delete(@RequestBody Produto produto) {
        serviceProduto.deletar(produto, produto.getId());
        return "";
    }
}
