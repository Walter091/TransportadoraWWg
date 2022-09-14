package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceProduto implements IntfcServiceProduto {

    @Autowired
    private RepositoryProduto repositorio;

    @Autowired
    private ServiceValidationsProduto validationsProduto;

    @Override
    public Iterable<Produto> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Produto buscarProduto(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public boolean salvar(Produto produto) {
        validationsProduto.doAntesDeSalvar();

        return true;
    }

    @Override
    public boolean alterar(Produto produto) {
        validationsProduto.doAntesDeAlterar();

        return true;
    }

    @Override
    public boolean deletar(Produto produto) {
        validationsProduto.doAntesDeExcluir();

        return true;
    }
}
