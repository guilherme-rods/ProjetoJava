package br.edu.up.Modelos;

public class ClienteEmpresa extends Cliente{

    private String cnpj;
    private String nome_representante;
    private String telefone_representante;

    public ClienteEmpresa(String nome, String telefone, Endereco endereco, String cnpj, String nome_representante,
            String telefone_representante) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.nome_representante = nome_representante;
        this.telefone_representante = telefone_representante;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_representante() {
        return nome_representante;
    }

    public void setNome_representante(String nome_representante) {
        this.nome_representante = nome_representante;
    }

    public String getTelefone_representante() {
        return telefone_representante;
    }

    public void setTelefone_representante(String telefone_representante) {
        this.telefone_representante = telefone_representante;
    }

    @Override
    public String toString() {
        return "ClienteEmpresa [nome=" + nome + 
        ", cnpj=" + cnpj + 
        ", telefone=" + telefone + 
        ", nome_representante=" + nome_representante + 
        ", endereco=" + endereco + 
        ", telefone_representante=" + telefone_representante + "]";
    }
}