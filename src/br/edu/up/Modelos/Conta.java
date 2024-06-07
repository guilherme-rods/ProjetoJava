package br.edu.up.Modelos;

public abstract class Conta {

    protected int num_conta;
    protected double  saldo;
    protected Cliente cliente;

    public Conta(int num_conta, double saldo, Cliente cliente) {
        this.num_conta = num_conta;
        this.saldo = saldo;
        this.cliente = cliente;
        
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public abstract String movimentar(double valor, boolean entrada);

    @Override
    public String toString() {
        return "Conta [num_conta=" + num_conta +
        ", cliente=" + cliente + "]";
    }
    public abstract String close();
}