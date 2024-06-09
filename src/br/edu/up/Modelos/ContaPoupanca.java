package br.edu.up.Modelos;

public class ContaPoupanca extends Conta {
    
    private double rendimentoMensal = 0.6; // taxa selic

    public ContaPoupanca(int num_conta, double saldo, int cliente) {
        super(num_conta, saldo, cliente);
        this.tipo = 2;
        ativa = true;
        
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(rendimentoMensal);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContaPoupanca other = (ContaPoupanca) obj;
        if (Double.doubleToLongBits(rendimentoMensal) != Double.doubleToLongBits(other.rendimentoMensal))
            return false;
        return true;
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

       ativa = false;
        saldo = 0 ;
       return msg;
   }
   public String ToStringCSV() {
    return num_conta + ";" + tipo + ";" + saldo + ";" + cliente + ";" + rendimentoMensal+";"+ativa;
}
}
