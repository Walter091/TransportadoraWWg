package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios.CreateReports;
import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryLancamento;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLancamento extends ServicoBase<Lancamento> {
    
    @Autowired
    private RepositoryLancamento repositorio;

    @Autowired
    private ServicePessoa servicoPessoa;

    @Autowired
    private ServiceProduto servicoProduto;
    
    private StatusFormularioEnum statusFormulario;
    
    @Getter
    @Setter
    public String ERRO = " ";
    
    @Override
    public void implementaDelete(Long id) {
        try {
            repositorio.deleteUpdate(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void implementaAlterar(Lancamento obj) {
        statusFormulario = StatusFormularioEnum.ALTERAR;
        Optional<Lancamento> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setDataSaida(obj.getDataSaida());
        objAlterado.get().setDataEntrega(obj.getDataEntrega());        
        objAlterado.get().setProduto(obj.getProduto());        
        objAlterado.get().setRemetente(obj.getRemetente());        
        objAlterado.get().setDestinatario(obj.getDestinatario());
        objAlterado.get().setStatus(obj.getStatus());        
        
        super.salvar(objAlterado.get());
    }

    // -------------------------------------------------------------------------
    
    public void gerarRelatorio(List<Lancamento> lista, OutputStream saida){        
        CreateReports report = new CreateReports();
        report.criarRelatorio(lista, saida);
    }

    @Override
    public boolean doAntesDeSalvar(Lancamento obj) {
        if (statusFormulario != StatusFormularioEnum.ALTERAR) {
            if (obj.getDataSaida().equals(obj.getDataEntrega())) {
                setERRO("Data de Entrega não pode ser igual a Data de Saída");
                return false;
            }

    //        if (obj.getDataSaida().compareTo(obj.getDataEntrega()) == 0) {
    //            setERRO("Data de Entrega não pode ser menor que a Data de Saída");
    //            return false;
    //        }

            if (obj.getRemetente().equals(obj.getDestinatario())) {
                setERRO("Destinatário deve ser Diferente que o Remetente");
                return false;
            }
            
        }
        
        return true; 
    }

    // -------------------------------------------------------------------------

    public Iterable<Lancamento> getListLancamentos(){
        return repositorio.buscarLista();
    }

    public Iterable<Pessoa> getListPessoas(){
        return servicoPessoa.buscarListaPessoa();
    }

    public Iterable<Produto> getListProdutos(){
        return servicoProduto.buscarTodos();
    }
    
}
