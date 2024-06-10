package br.edu.up.Modelos;

import java.util.Date;

public abstract class Cartao {

    protected int idCartao;
    protected int num_cartao;
    protected int num_conta;
    protected Date validade;
    protected String bandeira;
    public int tipoCartao;

    public Cartao(int idCartao, int num_cartao, int num_conta, Date validade, String bandeira, int tipoCartao) {
        this.idCartao = idCartao;
        this.num_cartao = num_cartao;
        this.num_conta = num_conta;
        this.validade = validade;
        this.bandeira = bandeira;
        this.tipoCartao = tipoCartao;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public int getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(int num_cartao) {
        this.num_cartao = num_cartao;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public int getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(int tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    @Override
    public String toString() {
        return "Cartao [idCartao=" + idCartao + ", num_cartao=" + num_cartao + ", num_conta=" + num_conta
                + ", validade=" + validade + ", bandeira=" + bandeira + ", tipoCartao=" + tipoCartao + "]";
    }
}    