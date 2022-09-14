package br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import java.util.List;

public interface itfcReport {
    
    void criarRelatorio(List<Lancamento> dataSource);
    void exibirRelatorio();
    void popularDataSource();
    
}
