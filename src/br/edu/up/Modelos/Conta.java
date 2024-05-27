package br.edu.up.Modelos;

import java.util.List;

public class Conta {

    private int num_conta;
    private List<Cartao> cartoes;
    private Cliente cliente;

    public Conta(int num_conta, List<Cartao> cartoes, Cliente cliente) {
        this.num_conta = num_conta;
        this.cartoes = cartoes;
        this.cliente = cliente;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta [num_conta=" + num_conta + 
        ", cartoes=" + cartoes + 
        ", cliente=" + cliente + "]";
    }
}