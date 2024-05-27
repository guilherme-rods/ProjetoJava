package br.edu.up.Modelos;

public class Endereco {

    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String num_residencial;

    public Endereco(String cep, String estado, String cidade, String bairro, String logradouro,
            String num_residencial) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.num_residencial = num_residencial;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero_residencial() {
        return num_residencial;
    }

    public void setNumero_residencial(String num_residencial) {
        this.num_residencial = num_residencial;
    }

    @Override
    public String toString() {
        return "Endereco [cep=" + cep + 
        ", estado=" + estado + 
        ", cidade=" + cidade + 
        ", bairro=" + bairro + 
        ", logradouro=" + logradouro + 
        ", num_residencial=" + num_residencial + "]";
    }
}