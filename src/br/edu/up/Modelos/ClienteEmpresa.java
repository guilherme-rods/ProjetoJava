package br.edu.up.Modelos;

public class ClienteEmpresa extends Cliente{
    private String cnpj;
    private String nome_representante;
    private String telefone_representante;

    public ClienteEmpresa(String nome, String telefone, String cnpj, String nome_representante,
            String telefone_representante) {
        super(nome, telefone);
        this.cnpj = cnpj;
        this.nome_representante = nome_representante;
        this.telefone_representante = telefone_representante;
    }

    @Override
    public String getDocumento() {
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
        var sb = new StringBuilder();
        sb.append("Nome: ").append(getNome()).append('\n');
        sb.append("Telefone: ").append(getTelefone()).append('\n');
        sb.append("Documento: ").append(getDocumento()).append('\n');
        sb.append("Nome representante: ").append(getNome_representante()).append('\n');
        sb.append("Telefone representante: ").append(getTelefone_representante()).append('\n');

        return sb.toString();
    }
}