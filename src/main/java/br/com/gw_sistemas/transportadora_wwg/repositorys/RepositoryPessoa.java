package br.com.gw_sistemas.transportadora_wwg.repositorys;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPessoa extends JpaRepository<Pessoa, Long>{
    
}
