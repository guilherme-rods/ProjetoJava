package br.edu.up.Modelos;

public abstract class Conta {

    protected int num_conta;
    protected double  saldo;
    protected Cliente cliente;

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
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    @Override
    public String toString() {
        return "Conta [num_conta=" + num_conta +
        ", cliente=" + cliente + "]";
    }
}