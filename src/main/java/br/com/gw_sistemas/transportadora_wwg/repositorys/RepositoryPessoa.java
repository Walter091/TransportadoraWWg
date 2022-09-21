package br.com.gw_sistemas.transportadora_wwg.repositorys;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.RepositorioBase;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPessoa extends RepositorioBase<Pessoa>{

    @Query(value = "UPDATE pessoa SET IND_REG= 1 WHERE id= :id", nativeQuery = true) 
    public void deleteUpdate(@Param("id") Long id);

    @Query(value = "SELECT * FROM pessoa WHERE IND_REG= 0", nativeQuery = true) 
    public Iterable<Pessoa> buscarLista();

}
