package br.edu.up.Modelos;

public class ContaSalario extends Conta {

    public ContaSalario(int num_conta, double saldo, int cliente) {
        super(num_conta, saldo, cliente);
        this.tipo = 3;
        ativa = true;
        
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
    public String ToStringCSV() {
        return num_conta + ";" + tipo + ";" + saldo + ";" + cliente+";;"+ativa;
    }

    @Override
    public String toString() {
        return "ContaSalario [num_conta=" + num_conta + ", saldo=" + saldo + ", cliente=" + cliente + "]";
    }
    public String close(){
        String msg = "saque realizado "+ saldo;
       ativa = false;
        saldo = 0 ;
       return msg;
   }
}
