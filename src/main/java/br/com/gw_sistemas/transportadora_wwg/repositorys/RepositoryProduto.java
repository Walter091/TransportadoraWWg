package br.com.gw_sistemas.transportadora_wwg.repositorys;

import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto, Long>{

}
