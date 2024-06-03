package br.edu.up.Modelos;

public class ContaCorrente extends Conta {
    
    private double limiteChequeEspecial;

    public ContaCorrente(int num_conta, double saldo, Cliente cliente, double limiteChequeEspecial) {
        this.num_conta = num_conta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void sacar(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            contaDestino.depositar(valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente [num_conta=" + num_conta + ", saldo=" + saldo + ", cliente=" + cliente + ", limiteChequeEspecial=" + limiteChequeEspecial + "]";
    }
}
