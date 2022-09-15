package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryProduto;
import br.com.gw_sistemas.transportadorawwg.nucleo.base.RetornoRequisicao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduto extends ServiceValidationsProduto {

    @Autowired
    private RepositoryProduto repositorio;

    private RetornoRequisicao retornoRequisicao = new RetornoRequisicao();

    public Iterable<Produto> buscarTodos() {
        return repositorio.findAll();
    }

    public Produto buscarTodosByID(Long id) {
        return repositorio.findById(id).get();
    }

    public RetornoRequisicao salvar(Produto produto) {
        try {
            if (doAntesDeSalvar(produto)) {
                repositorio.save(produto);

                retornoRequisicao.setMensagem("produto cadastrado com sucesso");
                retornoRequisicao.setStatusRequisicao(true);

                return retornoRequisicao;
            } else {

                throw new Exception("não foi possivel cadastrar este produto, verifique se todos os dados foram preenchidos corretamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            retornoRequisicao.setMensagem(e.getMessage());
            retornoRequisicao.setStatusRequisicao(false);

            return retornoRequisicao;
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
