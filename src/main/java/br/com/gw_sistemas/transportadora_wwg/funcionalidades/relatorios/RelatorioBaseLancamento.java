package br.com.gw_sistemas.transportadora_wwg.funcionalidades.relatorios;

import br.com.gw_sistemas.transportadora_wwg.model.Lancamento;
import java.util.List;

public class RelatorioBaseLancamento {
    
    private Long id;
    private String titulo;
    private String descricao;
    private List<Lancamento> lancamentos;

    public RelatorioBaseLancamento(String titulo, String descricao, List<Lancamento> lancamento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.lancamentos = lancamento;
    }

    // -------------------------------------------------------------------------
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamento(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
}
