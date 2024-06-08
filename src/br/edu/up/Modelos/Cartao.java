package br.edu.up.Modelos;

import java.util.Date;

public class Cartao {

    private int num_cartao;
    private int cod_validacao;
    private Date validade;
    private Cliente cliente;
    private String bandeira;
    private boolean titular;
    private boolean bloqueado;
    private double lim_credito;
    private TipoCartaoEnum tipo_operacao;
    private Date emissao;
    private Date vencimento;

    public Cartao(int num_cartao, int cod_validacao, Date validade, Cliente cliente, String bandeira, boolean titular, boolean bloqueado,
            double lim_credito, TipoCartaoEnum tipo_operacao, Date emissao, Date vencimento) {
        this.num_cartao = num_cartao;
        this.cod_validacao = cod_validacao;
        this.validade = validade;
        this.cliente = cliente;
        this.bandeira = bandeira;
        this.titular = titular;
        this.bloqueado = bloqueado;
        this.lim_credito = lim_credito;
        this.tipo_operacao = tipo_operacao;
        this.emissao = emissao;
        this.vencimento = vencimento;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBandeira(){
        return bandeira;
    }

    public void setBandeira(String bandeira){
        this.bandeira = bandeira;
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
    public Date getEmissao(){
        return emissao;
    }
    
    public void setEmissao(Date emissao){
        this.emissao = emissao;
    }

    @Override
    public String toString() {
        return "Cartao [num_cartao=" + num_cartao + 
        ", cod_validacao=" + cod_validacao + 
        ", validade=" + validade + 
        ", nome=" + cliente.getNome() + 
        ", titular=" + titular + 
        ", bloqueado=" + bloqueado + 
        ", lim_credito=" + lim_credito + 
        ", tipo_operacao=" + tipo_operacao + "]";
    }
} 