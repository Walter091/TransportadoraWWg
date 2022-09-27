package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryProduto;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ExceptionValidacao;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ValidationsEnum;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduto extends ServicoBase<Produto> {

    @Autowired
    private RepositoryProduto repositorio;
    
    @Override
    public void implementaDelete(Long id) {
       try {
            repositorio.deleteUpdate(id);                
        } catch (Exception ex) {
            new ExceptionValidacao(ValidationsEnum.NULL_POINTER, ex.getMessage());
        } 
    }
    
    @Override
    public void implementaAlterar(Produto obj) {
        Optional<Produto> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setNome(obj.getNome());        
        objAlterado.get().setDescricao(obj.getDescricao());
        objAlterado.get().setPeso(obj.getPeso());        
        objAlterado.get().setPreco(obj.getPreco());        
        objAlterado.get().setPreco(obj.getVolume());        
       
        super.salvar(objAlterado.get());
            
    }

    @Override
    public boolean doAntesDeSalvar(Produto obj) {
        boolean result = false;
        if (obj.getPeso() >= 1) result = true; 
        if (obj.getPreco() >= 1) result = true; 
        if (obj.getVolume() >= 1) result = true;  
        else {
            setERRO("Todos os campos devem ser preenchidos");
        }
        return result;
    }
    
    // -------------------------------------------------------------------------
    
     public Iterable<Produto> buscarListaProduto(){
        return repositorio.buscarLista();
    }
    
}
