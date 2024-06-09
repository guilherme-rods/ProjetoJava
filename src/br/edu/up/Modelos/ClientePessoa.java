package br.edu.up.Modelos;

public class ClientePessoa extends Cliente{
  public ClientePessoa(int id, String nome, String telefone) {
    super(id, nome, telefone);
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
}
