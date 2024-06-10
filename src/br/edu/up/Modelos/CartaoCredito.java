package br.edu.up.Modelos;

import java.util.Date;

public class CartaoCredito extends Cartao {
    private double limite;
    private double saldoUtilizado;

    public CartaoCredito(int idCartao, int num_cartao, int num_conta, Date validade, String bandeira, int tipoCartao,
            double limite, double saldoUtilizado) {
        super(idCartao, num_cartao, num_conta, validade, bandeira, tipoCartao = 1);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }

    @Override
    public String toString() {
        return "CartaoCredito [idCartao=" + idCartao + ", limite=" + limite + ", num_cartao=" + num_cartao
                + ", saldoUtilizado=" + saldoUtilizado + ", num_conta=" + num_conta + ", validade=" + validade
                + ", bandeira=" + bandeira + ", tipoCartao=" + tipoCartao + "]";
    }
}