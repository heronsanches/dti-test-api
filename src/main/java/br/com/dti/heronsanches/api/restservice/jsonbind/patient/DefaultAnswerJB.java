package br.com.dti.heronsanches.api.restservice.jsonbind.patient;

/** @author heronsanches */
public class DefaultAnswerJB {
    private boolean sucesso;
    private String mensagemErro;

    public boolean isSucesso() { return sucesso; }

    public void setSucesso(boolean sucesso) { this.sucesso = sucesso; }

    public String getMensagemErro() { return mensagemErro; }

    public void setMensagemErro(String mensagemErro) { this.mensagemErro = mensagemErro; }
}
