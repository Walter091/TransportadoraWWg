package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryProduto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduto extends ServicoBase<Produto> {

    @Autowired
    private RepositoryProduto repositorio;

    @Override
    public void implementaDelete(Long id) {
        repositorio.deleteUpdate(id);
    }

    @Override
    public void implementaAlterar(Produto obj) {
        Optional<Produto> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setDescricao(obj.getDescricao());
        objAlterado.get().setNome(obj.getNome());        
        objAlterado.get().setPeso(obj.getPeso());        
        objAlterado.get().setPreco(obj.getPreco());        
        objAlterado.get().setPreco(obj.getVolume());        
       
        super.salvar(objAlterado.get());
            
    }
    
}
