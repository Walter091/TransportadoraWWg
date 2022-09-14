package br.com.gw_sistemas.transportadora_wwg.enums;

import br.com.gw_sistemas.transportadorawwg.nucleo.base.itfcEnumBase;

public enum StatusEnum implements itfcEnumBase {
    
    EM_TRANSITO("EM TRÂNSITO", "ET", 0),
    EM_DEPOSITO("EM DEPÓSITO", "ED", 1), 
    ENTREGUE("ENTREGUE", "EG", 2), 
    CANCELADO("CANCELADO", "CD", 3);

    private String descricao;
    private String sigla;
    private int id;

    private StatusEnum(String descricao, String sigla, int id) {
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
