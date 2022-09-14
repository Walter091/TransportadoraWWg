package br.com.gw_sistemas.transportadorawwg.nucleo.validacoesExceptions;

public class ExceptionValidacao extends Exception {
    
    private ValidationsEnum erros;
    
    public ExceptionValidacao(ValidationsEnum erros, String string) {
        super(string);
        this.erros = erros;
        if (erros == ValidationsEnum.NULL_POINTER) System.out.println(erros.NULL_POINTER.getDescricao());
    }
    
}
