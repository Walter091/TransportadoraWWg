package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryPessoa;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePessoa extends ServicoBase<Pessoa> {

    @Autowired
    private RepositoryPessoa repositorio;

    @Override
    public void implementaDelete(Long id) {
        repositorio.deleteUpdate(id);
    }

    @Override
    public void implementaAlterar(Pessoa obj) {
        // Implementar Validações...
        Optional<Pessoa> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setNome(obj.getNome());
        objAlterado.get().setCpf(obj.getCpf());
        objAlterado.get().setCnpj(obj.getCnpj());
        objAlterado.get().setRazaoSocial(obj.getRazaoSocial());
        objAlterado.get().setUf(obj.getUf());
        objAlterado.get().setCidade(obj.getCidade());
        objAlterado.get().setBairro(obj.getBairro());

        super.salvar(objAlterado.get());
    }
}
