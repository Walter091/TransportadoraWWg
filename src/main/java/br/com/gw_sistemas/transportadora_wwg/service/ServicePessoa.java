package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryPessoa;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePessoa extends ServiceValidationsPersona {
    
    @Autowired
    private RepositoryPessoa repositorio;
    
    public void salvar(Pessoa pessoa){
        repositorio.save(pessoa);
    }
    
    public void alterar(Pessoa pessoa){
        // Implementar...
    }
    
    public void Excluir(Pessoa pessoa){
        // Implementar...
    }
    
    public Iterable<Pessoa> buscarTodos(){
        return repositorio.findAll();
    }
    
    public Optional<Pessoa> buscarTodosByID(Long id){
        return repositorio.findById(id);
    }
    
}
