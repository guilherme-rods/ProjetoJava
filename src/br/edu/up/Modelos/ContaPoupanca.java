package br.edu.up.Modelos;

public class ContaPoupanca extends Conta {
    
    private double rendimentoMensal = 0.6; // taxa selic

    public ContaPoupanca(int num_conta, double saldo, Cliente cliente) {
        super(num_conta, saldo, cliente);
        
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public String movimentar(double valor, boolean entrada) {
        if (entrada) {
            saldo += valor;
            return "depositado";
        }

        if (valor <= saldo) {
            saldo -= valor;
            return "saque efetuado saldo restante é de " + saldo;

        }
        throw new IllegalArgumentException("Saldo insuficiente.");

    }

    @Override
    public String toString() {
        return "ContaPoupanca [num_conta=" + num_conta + ", saldo=" + saldo + ", cliente=" + cliente + ", rendimentoMensal=" + rendimentoMensal + "]";
    }
    public String close(){
        String msg = "saque realizado "+ saldo;
       
        saldo = 0 ;
       return msg;
   }
}
