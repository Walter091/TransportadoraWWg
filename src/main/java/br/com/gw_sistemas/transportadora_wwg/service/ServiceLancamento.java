package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryLancamento;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class ServiceLancamento extends ServicoBase<Lancamento> {

    @Autowired
    private RepositoryLancamento repositorio;

    @Autowired
    private ServicePessoa servicoPessoa;

    @Autowired
    private ServiceProduto servicoProduto;

    private StatusFormularioEnum statusFormulario;

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

    @Override
    public boolean doAntesDeSalvar(Lancamento obj) {
        if (statusFormulario != StatusFormularioEnum.ALTERAR) {
            if (obj.getDataSaida().equals(obj.getDataEntrega())) {
                setERRO("Data de Entrega não pode ser igual a Data de Saída");
                return false;
            }

            if (obj.getRemetente().equals(obj.getDestinatario())) {
                setERRO("Destinatário deve ser Diferente que o Remetente");
                return false;
            }

        }

        return true;
    }

    // -------------------------------------------------------------------------
    public Iterable<Lancamento> getListLancamentos() {
       Iterable<Lancamento> todosLancamentos = repositorio.buscarLista();
        
       try {
            todosLancamentos.forEach(item -> {
                if (item.getRemetente().getCpf().equals("")) item.getRemetente().setCpf(null);  
                else if (item.getRemetente().getCnpj().equals("")) item.getRemetente().setCnpj(null); 

                if (item.getDestinatario().getCpf().equals("")) item.getDestinatario().setCpf(null);  
                else if (item.getDestinatario().getCnpj().equals("")) item.getDestinatario().setCnpj(null); 
            });
       } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return todosLancamentos;
    }

    public Iterable<Pessoa> getListPessoas() {
        Iterable<Pessoa> listaPessoa = servicoPessoa.buscarListaPessoa();
        
        try {
            for (Pessoa item : listaPessoa) {
                if (item.getCpf().equals("")) item.setCpf(null);
                else if (item.getCnpj().equals("")) item.setCnpj(null);
            }; 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         
        return listaPessoa;
    }

    public Iterable<Produto> getListProdutos() {
        return servicoProduto.buscarTodos();
    }

    // -----------------------------------------------------------------------------------
    
    public byte[] exportReport() throws FileNotFoundException, JRException {
        List<Lancamento> lista = (List<Lancamento>) getListLancamentos();
        File file = ResourceUtils.getFile("classpath:relatorioBaseLancamento.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "Lancamentos.pdf");
        
        byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);
        
        return data;
    }

}
