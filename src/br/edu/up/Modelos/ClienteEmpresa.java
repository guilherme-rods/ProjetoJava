package br.edu.up.Modelos;

public class ClienteEmpresa extends Cliente {

    private String nomeRepresentante;
    private String telefoneRepresentante;
    private String documento;

    public ClienteEmpresa(int id, String nome, String telefone, String cnpj, String nomeRepresentante, String telefoneRepresentante) {
        super(id, nome, telefone);
        this.setDocumento(cnpj);
        this.nomeRepresentante = nomeRepresentante;
        this.telefoneRepresentante = telefoneRepresentante;
    }

    public ClienteEmpresa(String nome, String telefone, String cnpj, String nomeRepresentante, String telefoneRepresentante) {
        super(nome, telefone);
        this.setDocumento(cnpj);
        this.nomeRepresentante = nomeRepresentante;
        this.telefoneRepresentante = telefoneRepresentante;
    }

    @Override
    public String ToStringCSV() {
        return getId() + ";" + getNome() + ";" + getDocumento() + ";" + getTelefone() + ";2;" + nomeRepresentante + ";" + telefoneRepresentante;
    }

    public String getNome_representante() {
        return nomeRepresentante;
    }

    public void setNome_representante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getTelefoneRepresentante() {
        return telefoneRepresentante;
    }

    public void setTelefoneRepresentante(String telefoneRepresentante) {
        this.telefoneRepresentante = telefoneRepresentante;
    }

    @Override
    public String getDocumento() {
        return documento;

    }

    @Override
    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
