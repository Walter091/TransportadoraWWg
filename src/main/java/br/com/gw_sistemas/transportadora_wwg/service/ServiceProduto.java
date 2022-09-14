package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduto extends ServiceValidationsProduto {

    @Autowired
    private RepositoryProduto repositorio;

    public Iterable<Produto> buscarTodos() {
        return repositorio.findAll();
    }

    public Produto buscarTodosByID(Long id) {
        return repositorio.findById(id).get();
    }

    public String salvar(Produto produto) {
        try {
            if (doAntesDeSalvar(produto)) {
                repositorio.save(produto);
                return "produto cadastrado com sucesso";
            } else {
                return "não foi possivel cadastrar este produto, verifique se todos os dados foram preenchidos corretamente";
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public boolean alterar(Produto produto) {
        if (doAntesDeAlterar()) {

        } else {

        }
        return true;
    }

    public boolean deletar(Produto produto) {

        return doAntesDeExcluir();
    }
}
