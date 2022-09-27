package br.com.gw_sistemas.transportadora_wwg.service;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.repositorys.RepositoryPessoa;
import br.com.gw_sistemas.transportadorawwg.nucleo.utils.stringUtils.Cnpj;
import br.com.gw_sistemas.transportadorawwg.nucleo.utils.stringUtils.Cpf;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ExceptionValidacao;
import br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions.ValidationsEnum;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePessoa extends ServicoBase<Pessoa> {

    @Autowired
    private RepositoryPessoa repositorio;
    
    @Override
    public void implementaDelete(Long id) {
        try {
            repositorio.deleteUpdate(id);                
        } catch (Exception ex) {
            new ExceptionValidacao(ValidationsEnum.NULL_POINTER, ex.getMessage());
        } 
    }

    @Override
    public void implementaAlterar(Pessoa obj) {
        Optional<Pessoa> objAlterado = repositorio.findById(obj.getId());
        objAlterado.get().setNome(obj.getNome());
        objAlterado.get().setCpf(obj.getCpf());
        objAlterado.get().setCnpj(obj.getCnpj());
        objAlterado.get().setRazaoSocial(obj.getRazaoSocial());
        objAlterado.get().setUf(obj.getUf());
        objAlterado.get().setRua(obj.getRua());
        objAlterado.get().setCidade(obj.getCidade());
        objAlterado.get().setBairro(obj.getBairro());

        super.salvar(objAlterado.get());
    }
    
    // ------------------------------------------------------------------------
    
    public Iterable<Pessoa> buscarListaPessoa(){
        Iterable<Pessoa> listaPessoa = repositorio.buscarLista();

        try {
            listaPessoa.forEach(item -> {
                if (item.getCpf().equals("")) item.setCpf(null);
                else if (item.getCnpj().equals("")) item.setCnpj(null);
            });

        } catch (Exception ex) {
            new ExceptionValidacao(ValidationsEnum.NULL_POINTER, ex.getMessage());
        } 
        
        return listaPessoa;
    }
    
    // ------------------------------------------------------------------------

    @Override
    public boolean doAntesDeSalvar(Pessoa obj) {
        boolean result  = false;
        if (obj.getCpf()!= null) {
            if (!obj.getCpf().isEmpty() || obj.getCpf().length() >  0) {         
                if (validarCpfPessoa(obj.getCpf())) result = true;
                else {
                    setERRO("CPF Inválido");
                    obj.setCpf(null);
                    result = false;
                }
            }
        }
        
        if (obj.getCnpj() != null) {
            if (!obj.getCnpj().isEmpty() || obj.getCnpj().length() >  0) {
                if (validarCnpjPessoa(obj.getCnpj())) result = true;
                else {
                    setERRO("CNPJ Inválido");
                    obj.setCnpj(null);
                    result = false;
                }
            }
            
        }
        
        return result;
    }
    
    public boolean validarCpfPessoa(String cpf){
        // Vallidando CPF...
        boolean result = false;
        Cpf validation = new Cpf();
        if (validation.isValidCpf(cpf)) {
            result = true;
        } 

        if (repositorio.validarCpf(cpf) == null) {
            setERRO("CPF JÁ CADASTRADO...");
            result = false;
        } 

        return result;
    }
    
    public boolean validarCnpjPessoa(String cnpj){
        // Vallidando CNPJ...
        boolean result = false;
        Cnpj validation = new Cnpj();
        if (validation.isCNPJ(cnpj)) {
            return true;
        } 

        if (repositorio.validarCnpj(cnpj) == null) {
            setERRO("CNPJ JÁ CADASTRADO...");
            result = false;
        } 
        
        return result;
    }
}
