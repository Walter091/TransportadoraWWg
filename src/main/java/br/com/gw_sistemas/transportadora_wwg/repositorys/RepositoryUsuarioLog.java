package br.com.gw_sistemas.transportadora_wwg.repositorys;

import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.RepositorioBase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuarioLog extends RepositorioBase<UsuarioLog>{
    
      
    @Query(value = "SELECT * FROM usuario_log WHERE EMAIL=:email AND SENHA=:senha", nativeQuery = true) 
    public UsuarioLog buscarUsuarioComCredenciais(@Param("email") String email, @Param("senha") String senha);
}
