package br.edu.up.Modelos;

public class ClientePessoa extends Cliente {

    private String cpf;

    public ClientePessoa(int id, String nome, String telefone, String cpf) {
        super(id, nome, telefone);
        this.cpf = cpf;
    }

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

    @Override
    public String ToStringCSV() {
        return getId() + ";" + getNome() + ";" + cpf + ";" + getTelefone() + ";1;;";
    }
}
