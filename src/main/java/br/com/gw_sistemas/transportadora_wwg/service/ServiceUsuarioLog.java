package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryUsuarioLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuarioLog extends ServicoBase<UsuarioLog> {
    
    @Autowired
    private RepositoryUsuarioLog repositorio;
    
    @Override
    public void implementaDelete(Long id) {
        // Implementar...
    }

    @Override
    public void implementaAlterar(UsuarioLog obj) {
        // Implementar...
    }
    
    // --------------------------------------------------------------------------
   
    public boolean entrar(UsuarioLog obj) {
        if (doAntesDeEntrar(obj)) return true;
        else return false;
    
    }
    
    public boolean doAntesDeEntrar(UsuarioLog obj){
        if (repositorio.buscarUsuarioComCredenciais(obj.getNomeDeUsuario(), obj.getEmail(), obj.getSenha()) == null) {
            return false;
        }
        return true;
    }
    
}
