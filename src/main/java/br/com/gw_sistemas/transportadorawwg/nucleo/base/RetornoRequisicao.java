package br.com.gw_sistemas.transportadorawwg.nucleo.base;

public class RetornoRequisicao {

    private String mensagem;
    private boolean statusRequisicao;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean getStatusRequisicao() {
        return statusRequisicao;
    }

    public void setStatusRequisicao(boolean statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }
}
