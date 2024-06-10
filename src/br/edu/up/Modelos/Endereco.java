package br.edu.up.Modelos;

public class Endereco {
    private int id;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero_residencial;


    public Endereco(int id, String cep, String estado, String cidade, String bairro, String logradouro, String numero_residencial) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero_residencial = numero_residencial;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return numero_residencial;
    }

    public void setNumero_residencial(String numero_residencial) {
        this.numero_residencial = numero_residencial;
    }

    @Override
    public String toString() {
        return "\n--->{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero_residencial='" + numero_residencial + '\'' +
                "}\n";
    }
}