package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryPessoa;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ExceptionValidacao;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ValidationsEnum;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePessoa extends ServicoBase<Pessoa> {

    @Autowired
    private RepositoryPessoa repositorio;

    @Override
    public void implementaDelete(Long id) {
        try {
            repositorio.deleteUpdate(id);                
        } catch (Exception ex) {
            new ExceptionValidacao(ValidationsEnum.NULL_POINTER, ex.getMessage());
        } 
    }

    @Override
    public void implementaAlterar(Pessoa obj) {
        Optional<Pessoa> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setNome(obj.getNome());
        objAlterado.get().setCpf(obj.getCpf());
        objAlterado.get().setCnpj(obj.getCnpj());
        objAlterado.get().setRazaoSocial(obj.getRazaoSocial());
        objAlterado.get().setUf(obj.getUf());
        objAlterado.get().setRua(obj.getRua());
        objAlterado.get().setCidade(obj.getCidade());
        objAlterado.get().setBairro(obj.getBairro());

        super.salvar(objAlterado.get());
    }
    
    // ------------------------------------------------------------------------
    
    public Iterable<Pessoa> buscarListaPessoa(){
        return repositorio.buscarLista();
    }
    
}
