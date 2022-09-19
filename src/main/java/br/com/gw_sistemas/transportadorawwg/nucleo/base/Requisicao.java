package br.com.gw_sistemas.transportadorawwg.nucleo.base;

public class Requisicao {

    private String mensagem;
    private boolean status;

    
    public Requisicao () {
        this.mensagem = "";
    }
    
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
