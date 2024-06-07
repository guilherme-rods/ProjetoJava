package br.edu.up.Modelos;

public class ClientePessoa extends Cliente{

    private String cpf;

    public ClientePessoa(String nome, String telefone, String cpf) {
        super(nome, telefone);
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return cpf;
    }

    @Override
    public void setDocumento(String documento) {
        this.cpf = documento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Nome: ").append(getNome()).append('\n');
        sb.append("Telefone: ").append(getTelefone()).append('\n');
        sb.append("Documento: ").append(getDocumento()).append('\n');

        return sb.toString();
    }
}