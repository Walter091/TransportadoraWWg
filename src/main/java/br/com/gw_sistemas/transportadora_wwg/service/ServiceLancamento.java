package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios.CreateReports;
import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryLancamento;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLancamento extends ServiceValidationLancamento {
    
    @Autowired
    private RepositoryLancamento repositorio;
    
    public void salvar(Lancamento lancamento){
        repositorio.save(lancamento);
    }
    
    public void alterar(Lancamento lancamento){
        // Implementar...
    }
    
    public void Excluir(Lancamento lancamento){
        // Implementar...
    }
    
    public Iterable<Lancamento> buscarTodos(){
        return repositorio.findAll();
    }
    
    public Optional<Lancamento> buscarTodosByID(Long id){
        return repositorio.findById(id);
    }
    
    // -------------------------------------------------------------------------
    
    public void gerarRelatorio(){        
        CreateReports report = new CreateReports();
        report.criarRelatorio(repositorio.findAll());
    }
    
}
