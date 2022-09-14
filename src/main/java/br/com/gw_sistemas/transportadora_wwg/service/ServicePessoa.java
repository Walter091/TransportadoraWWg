package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePessoa {
    
    @Autowired
    private RepositoryPessoa repositorio;
    
    public void salvar(Pessoa pessoa){
        repositorio.save(pessoa);
    }
    
    public Iterable<Pessoa> buscarTodos(){
        return repositorio.findAll();
    }
}
