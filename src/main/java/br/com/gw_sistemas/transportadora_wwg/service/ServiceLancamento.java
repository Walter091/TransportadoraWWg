package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios.CreateReports;
import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryLancamento;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLancamento extends ServicoBase<Lancamento> {
    
    @Autowired
    private RepositoryLancamento repositorio;

    @Override
    public void implementaDelete(Long id) {
        repositorio.deleteUpdate(id);
    }

    @Override
    public void implementaAlterar(Lancamento obj) {
        // Implementar Validações...
        Optional<Lancamento> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setDataSaida(obj.getDataSaida());
        objAlterado.get().setDataEntrega(obj.getDataEntrega());        
        objAlterado.get().setProduto(obj.getProduto());        
        objAlterado.get().setRemetente(obj.getRemetente());        
        objAlterado.get().setDestinatario(obj.getDestinatario());
        objAlterado.get().setStatus(obj.getStatus());        
        
        super.salvar(objAlterado.get());
    }

    // -------------------------------------------------------------------------
    
    public void gerarRelatorio(){        
        CreateReports report = new CreateReports();
        report.criarRelatorio(repositorio.findAll());
    }
    
}
