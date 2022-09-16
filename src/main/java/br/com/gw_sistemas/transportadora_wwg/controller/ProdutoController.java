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

@RestController("/Transportadora/PR/")
class ProdutoController {

    @Autowired
    private ServiceProduto serviceProduto;

    @GetMapping("/produtos")
    public Iterable buscarTodos() {
        return serviceProduto.buscarTodos();
    }

    @GetMapping("/produtos/{id}")
    public Produto buscarTodosByID(@PathVariable("id") Long id) {
        return serviceProduto.buscarTodosByID(id);
    }

    @GetMapping("/Produtos/Cadastrar")
    public String formCadastro(@RequestBody Produto produto) {
        return "";
    }

    @PostMapping("/Produtos/Cadastrar/Salvar")
    public RetornoRequisicao salvar(@RequestBody Produto produto) {
        return serviceProduto.salvar(produto);
    }

    @PutMapping("/produtos/Editar")
    public String alterar(@RequestBody Produto produto) {
        serviceProduto.alterar(produto);
        return "";
    }

    @DeleteMapping("/Produtos/Delete")
    public String delete(@RequestBody Produto produto) {
        serviceProduto.deletar(produto, produto.getId());
        return "";
    }
}
