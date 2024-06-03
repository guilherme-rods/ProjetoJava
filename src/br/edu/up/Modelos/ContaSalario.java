package br.edu.up.Modelos;

public class ContaSalario extends Conta {

    public ContaSalario(int num_conta, double saldo, Cliente cliente) {
        this.num_conta = num_conta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public String toString() {
        return "ContaSalario [num_conta=" + num_conta + ", saldo=" + saldo + ", cliente=" + cliente + "]";
    }
}
