package br.edu.up.Modelos;

public class ClienteEmpresa extends Cliente {
    private String cnpj;
    private String nome_representante;
    private String telefoneRepresentante;

    public ClienteEmpresa(int id,
                          String nome,
                          String telefone,
                          String cnpj,
                          String nome_representante,
                          String telefoneRepresentante)
    {
        super(id, nome, telefone);
        this.telefoneRepresentante=telefoneRepresentante;
        this.nome_representante = nome_representante;
        this.cnpj=cnpj;
    }

    public ClienteEmpresa(String nome,
                          String telefone,
                          String cnpj,
                          String nome_representante,
                          String telefoneRepresentante)
    {
        super(nome, telefone);
        this.telefoneRepresentante=telefoneRepresentante;
        this.nome_representante = nome_representante;
        this.cnpj=cnpj;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }

    @Override
    public void setDocumento(String documento) {
        cnpj = documento;
    }

    public String getNome_representante() {
        return nome_representante;
    }

    public void setNome_representante(String nome_representante) {
        this.nome_representante = nome_representante;
    }

    public String getTelefoneRepresentante() {
        return telefoneRepresentante;
    }

    public void setTelefoneRepresentante(String telefoneRepresentante) {
        this.telefoneRepresentante = telefoneRepresentante;
    }

    @Override
    public String ToStringCSV() {
        return id + ';' + nome + ';' + telefone + ';' + cnpj + ';' + telefone + ';' + nome_representante + ';' + telefoneRepresentante;
    }
}
