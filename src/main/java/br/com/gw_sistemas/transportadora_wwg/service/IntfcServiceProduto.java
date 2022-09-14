package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;

public interface IntfcServiceProduto {
    Iterable<Produto> buscarTodos();
    
    Produto buscarProduto(Long id);
    
    boolean salvar(Produto produto);
    
    boolean alterar (Produto produto);
    
    boolean deletar (Produto produto);
}
