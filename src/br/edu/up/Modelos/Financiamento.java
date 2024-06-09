package br.edu.up.Modelos;

public abstract class Financiamento {

    protected int id;
    public int tipoFinanciamento;
    protected double valor;
    protected int prazo;

    public Financiamento(int id, double valor, int prazo) {
        this.id = id;
        this.valor = valor;
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
}