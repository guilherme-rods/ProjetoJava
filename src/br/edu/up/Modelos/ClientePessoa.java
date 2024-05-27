package br.edu.up.Modelos;

public class ClientePessoa extends Cliente{

    private String cpf;

    public ClientePessoa(String nome, String telefone, Endereco endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClientePessoa [nome=" + nome + 
        ", cpf=" + cpf + 
        ", telefone=" + telefone + 
        ", endereco=" + endereco + "]";
    }
}