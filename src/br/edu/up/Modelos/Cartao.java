package br.edu.up.Modelos;

import java.util.Date;

public class Cartao {

    private int num_cartao;
    private int cod_validacao;
    private Date validade;
    private String nome;
    private boolean titular;
    private boolean bloqueado;
    private double lim_credito;
    private TipoCartaoEnum tipo_operacao;

    public Cartao(int num_cartao, int cod_validacao, Date validade, String nome, boolean titular, boolean bloqueado,
            double lim_credito, TipoCartaoEnum tipo_operacao) {
        this.num_cartao = num_cartao;
        this.cod_validacao = cod_validacao;
        this.validade = validade;
        this.nome = nome;
        this.titular = titular;
        this.bloqueado = bloqueado;
        this.lim_credito = lim_credito;
        this.tipo_operacao = tipo_operacao;
    }


    public int getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(int num_cartao) {
        this.num_cartao = num_cartao;
    }

    public int getCod_validacao() {
        return cod_validacao;
    }

    public void setCod_validacao(int cod_validacao) {
        this.cod_validacao = cod_validacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public double getLim_credito() {
        return lim_credito;
    }

    public void setLim_credito(double lim_credito) {
        this.lim_credito = lim_credito;
    }

    public TipoCartaoEnum getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(TipoCartaoEnum tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }

    @Override
    public String toString() {
        return "Cartao [num_cartao=" + num_cartao + 
        ", cod_validacao=" + cod_validacao + 
        ", validade=" + validade + 
        ", nome=" + nome + 
        ", titular=" + titular + 
        ", bloqueado=" + bloqueado + 
        ", lim_credito=" + lim_credito + 
        ", tipo_operacao=" + tipo_operacao + "]";
    }
} 