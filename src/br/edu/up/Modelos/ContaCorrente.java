package br.edu.up.Modelos;

public class ContaCorrente extends Conta {

    private double depositoInicial; 
    private double limiteChequeEspecial = depositoInicial*2  ;

    public ContaCorrente(int num_conta, double saldo, Cliente cliente) {
        super(num_conta, saldo, cliente);
        this.depositoInicial = saldo;
        
    }

    public String movimentar(double valor, boolean entrada) {
        if (entrada) {
            saldo += valor;
            return "depositado";
        }

        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            return "saque efetuado saldo restante é de " + saldo;

        }
        throw new IllegalArgumentException("Saldo insuficiente.");

    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            contaDestino.movimentar(valor, true);
        }
        throw new IllegalArgumentException("Saldo insuficiente.");

    }

    @Override
    public String toString() {
        return "ContaCorrente [num_conta=" + num_conta + ", saldo=" + saldo + ", cliente=" + cliente
                + ", limiteChequeEspecial=" + limiteChequeEspecial + "]";
    }
    public String close(){
        String msg = "saque realizado "+ saldo;
        if(limiteChequeEspecial + saldo < depositoInicial*2){
            msg = "conta encerrada, Boleto de quitação será enviado em até 3 dias uteis";
        }
        saldo = 0 ;
       return msg;
   }
   
}
