package br.edu.up.Modelos;

public class ContaPoupanca extends Conta {
    
    private double rendimentoMensal;

    public ContaPoupanca(int num_conta, double saldo, Cliente cliente, double rendimentoMensal) {
        this.num_conta = num_conta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.rendimentoMensal = rendimentoMensal;
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

    public void aplicarRendimento() {
        saldo += saldo * rendimentoMensal / 100;
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
        return "ContaPoupanca [num_conta=" + num_conta + ", saldo=" + saldo + ", cliente=" + cliente + ", rendimentoMensal=" + rendimentoMensal + "]";
    }
}
