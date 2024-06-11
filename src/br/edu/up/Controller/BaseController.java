package br.edu.up.Controller;

import br.edu.up.DAO.*;

public class BaseController {

    private CartaoDAO cartaoDAO;
    private ClienteDAO clienteDAO;
    private CidadeDAO cidadeDAO;
    private EnderecoDAO enderecoDAO;
    private ContaDAO contaDAO;

    public BaseController(String caminhoArquivoCartao, String caminhoArquivoCliente, String caminhoArquivoCidade,
                          String caminhoArquivoEndereco, String caminhoArquivoConta, String caminhoArquivoFinanciamento) {
        this.cartaoDAO = new CartaoDAO(caminhoArquivoCartao);
        this.clienteDAO = new ClienteDAO("clientes.csv");
        this.cidadeDAO = new CidadeDAO("cidades.csv");
        this.enderecoDAO = new EnderecoDAO(caminhoArquivoEndereco, this.cidadeDAO);
        this.contaDAO = new ContaDAO(caminhoArquivoConta);
    }

    // Getters for each DAO if needed
    public CartaoDAO getCartaoDAO() {
        return cartaoDAO;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public CidadeDAO getCidadeDAO() {
        return cidadeDAO;
    }

    public EnderecoDAO getEnderecoDAO() {
        return enderecoDAO;
    }

    public ContaDAO getContaDAO() {
        return contaDAO;
    }
}
