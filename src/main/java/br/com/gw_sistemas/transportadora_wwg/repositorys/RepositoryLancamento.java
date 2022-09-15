package br.com.gw_sistemas.transportadora_wwg.repositorys;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.RepositorioBase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLancamento extends RepositorioBase<Lancamento>{

    @Query(value = "UPDATE lancamento SET IND_REG= 1 WHERE id= :id", nativeQuery = true) 
    public void deleteUpdate(@Param("id") Long id);

}
