package br.edu.up.Modelos;

import java.util.Date;

public class CartaoDebito extends Cartao {
    private double saldo;

    public CartaoDebito(int idCartao, int num_cartao, int num_conta, Date validade, String bandeira, int tipoCartao,
            double saldo) {
        super(idCartao, num_cartao, num_conta, validade, bandeira, tipoCartao = 2);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CartaoDebito [idCartao=" + idCartao + ", saldo=" + saldo + ", num_cartao=" + num_cartao + ", num_conta="
                + num_conta + ", validade=" + validade + ", bandeira=" + bandeira + ", tipoCartao=" + tipoCartao + "]";
    }
}