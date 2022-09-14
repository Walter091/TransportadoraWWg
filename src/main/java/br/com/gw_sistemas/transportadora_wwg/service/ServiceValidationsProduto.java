package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;

public class ServiceValidationsProduto  {

    protected boolean doAntesDeSalvar(Produto produto) {
        
        
        return true;
    }

    protected boolean doAntesDeAlterar() {
        // implementar validações antes de Alterar....

        return true;
    }

    protected boolean doAntesDeExcluir() {
        // implementar validações antes de Excluir....

        return true;
    }
}
