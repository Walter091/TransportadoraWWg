package br.com.gw_sistemas.transportadora_wwg.nucleo.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositorioBase<T> extends JpaRepository<T, Long> {

}
