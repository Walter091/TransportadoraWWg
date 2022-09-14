package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;

public interface IntfcServiceBase {
    
    void salvar(Pessoa obj);
    
    Iterable<Pessoa> buscarTodos(); 
}
