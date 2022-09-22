package br.com.gw_sistemas.transportadora_wwg.enums;

import lombok.Getter;

public enum UfEnum {
    RO("Rondônia", "RO", 11),
    AC("Acre", "AC", 12),
    AM("Amazonas", "AM", 13),
    RR("Roraima", "RR", 14),
    PA("Pará", "PA", 15),
    AP("Amapá", "AP", 16),
    TO("Tocantins", "TO", 17),
    MA("Maranhão", "MA", 21),
    PI("Piauí", "PI", 22),
    CE("Ceará", "CE", 23),
    RN("Rio Grande do Norte", "RN", 24),
    PB("Paraíba", "PB", 25),
    PE("Pernambuco", "PE", 26),
    AL("Alagoas", "AL", 27),
    SE("Sergipe", "SE", 28),
    BA("Bahia", "BA", 29),
    MG("Minas Gerais", "MG", 31),
    ES("Espírito Santo", "ES", 32),
    RJ("Rio de Janeiro", "RJ", 33),
    SP("São Paulo", "SP", 35),
    PR("Paraná", "PR", 41),
    SC("Santa Catarina", "SC", 42),
    RS("Rio Grande do Sul", "RS", 43),
    MS("Mato Grosso do Sul", "MS", 50),
    MT("Mato Grosso", "MT", 51),
    GO("Goiás", "GO", 52),
    DF("Distrito Federal", "DF", 54);

    private final String descricao;
    private final String sigla;
    private final int codigo;

    private UfEnum(String descricao, String sigla, int codigo) {
        this.descricao = descricao;
        this.sigla = sigla;
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public int getCodigo() {
        return codigo;
    }
}
