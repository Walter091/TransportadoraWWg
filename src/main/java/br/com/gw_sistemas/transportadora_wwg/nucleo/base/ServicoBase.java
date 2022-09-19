package br.com.gw_sistemas.transportadora_wwg.nucleo.base;

import br.com.gw_sistemas.transportadorawwg.nucleo.base.Requisicao;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ExceptionValidacao;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ValidationsEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServicoBase<T> implements ItfcServicoValidacaoBase<T> {

    @Autowired
    private RepositorioBase<T> repositorio;

    private Requisicao requisicao = new Requisicao();

    public Requisicao salvar(T obj) {
        try {
            if (doAntesDeSalvar(obj)) {
                repositorio.save(obj);

                requisicao.setMensagem("Sucesso na persistência da Entidade!!");
                requisicao.setStatus(true);

                return requisicao;
            } else {

                throw new Exception("Falha na persisteência! Verifique se as informações estão corretas.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            requisicao.setMensagem(e.getMessage());
            requisicao.setStatus(false);

            return requisicao;
        }
    }

    public boolean alterar(T obj) {
        if (doAntesDeAlterar(obj)) {
            implementaAlterar(obj);
            return true;
        } else {
            try {
                throw new Exception("Falha na Exclusão!");
            } catch (Exception ex) {
                new ExceptionValidacao(ValidationsEnum.NULL_POINTER, ex.getMessage());
            }
        }
        return false;
    }

    public boolean deletar(T obj, Long id) {
        // implementado no filho...
        if (doAntesDeExcluir(obj)) {
            implementaDelete(id);
            return true;
        } else {
            try {
                throw new Exception("Falha na Exclusão!");
            } catch (Exception ex) {
                new ExceptionValidacao(ValidationsEnum.NULL_POINTER, ex.getMessage());
            }
        }
        return false;
    }

    public abstract void implementaDelete(Long id);

    public abstract void implementaAlterar(T obj);

    // -------------------------------------------------------------------------------------------------------------------------
    public Iterable<T> buscarTodos() {
        return repositorio.findAll();
    }

    public T buscarTodosByID(Long id) {
        try {
            List<T> itens = (List<T>) repositorio.findById(id).get();
            return (T) itens;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // -------------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean doAntesDeSalvar(T obj) {
        // Imnplementar Validções nos filhos...
        return true;
    }

    @Override
    public boolean doAntesDeAlterar(T obj) {
        // Imnplementar Validções nos filhos...
        return true;
    }

    @Override
    public boolean doAntesDeExcluir(T obj) {
        // Imnplementar Validções nos filhos...
        return true;
    }

}
