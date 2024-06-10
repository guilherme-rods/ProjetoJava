package br.edu.up.Modelos;

public class ClientePessoa extends Cliente {
  public ClientePessoa(int id, String nome, String telefone, String cpf) {
    super(id, nome, telefone);
    this.cpf = cpf;
  }

  public ClientePessoa(String nome, String telefone, String cpf) {
    super(nome, telefone);
    this.cpf = cpf;
  }

  private String cpf;

  @Override
  public String getDocumento() {
    return cpf;
  }

  @Override
  public void setDocumento(String documento) {
    cpf = documento;
  }

  @Override
  public String ToStringCSV() {
    return id + ';' + nome + ';' + telefone + ';' + cpf + ';' + telefone;
  }
}
