package br.com.gw_sistemas.transportadora_wwg.enums;

import br.com.gw_sistemas.transportadorawwg.nucleo.base.itfcEnumBase;

public enum StatusFormularioEnum implements itfcEnumBase {

    SALVAR("SALVAR", "SL", 0),
    ALTERAR("ALTERAR", "AL", 1),
    EXCLUIR("EXCLUIR", "EX", 2),
    VIZUALIZAR("VIZUALIZAR", "VZ", 3),
    EM_ERRO("EM ERRO", "ERR", 4);
    
    private String descricao;
    private String sigla;
    private int id;

    private StatusFormularioEnum(String descricao, String sigla, int id) {
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
