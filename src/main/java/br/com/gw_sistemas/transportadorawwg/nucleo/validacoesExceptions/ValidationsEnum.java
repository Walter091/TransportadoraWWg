package br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions;

import br.com.gw_sistemas.transportadorawwg.nucleo.base.itfcEnumBase;

public enum ValidationsEnum implements itfcEnumBase {
    
    NULL_POINTER("ALGUM OBJETO ESTÁ RETORNANDO NULO", "NULL", 0);

     private String descricao;
    private String sigla;
    private int id;

    private ValidationsEnum(String descricao, String sigla, int id) {
        this.descricao = descricao;
        this.sigla = sigla;
        this.id = id;
    }
    
    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getSigla() {
        return sigla;
    }

    @Override
    public int getId() {
        return id;
    }
}
