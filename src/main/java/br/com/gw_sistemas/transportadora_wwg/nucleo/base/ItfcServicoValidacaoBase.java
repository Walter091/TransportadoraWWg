package br.com.gw_sistemas.transportadora_wwg.nucleo.base;

public interface ItfcServicoValidacaoBase<T> {
    
    boolean doAntesDeSalvar(T obj);

    boolean doAntesDeAlterar(T obj);

    boolean doAntesDeExcluir(T obj);
}