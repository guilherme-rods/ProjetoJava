package br.edu.up.Controller;

import br.edu.up.DAO.CidadeDAO;
import br.edu.up.DAO.EnderecoDAO;
import br.edu.up.Modelos.Endereco;
import java.io.IOException;
import java.util.List;

public class EnderecoController {
    private EnderecoDAO enderecoDAO;

    public EnderecoController() {
        CidadeDAO cidadeDAO = new CidadeDAO("cidades.csv");
        this.enderecoDAO = new EnderecoDAO("enderecos.csv", cidadeDAO);
    }

    public List<Endereco> listarEnderecos() throws IOException {
        List<Endereco> enderecos = enderecoDAO.lerEnderecos();
        return enderecos;
    }

    public void adicionarEndereco(Endereco endereco) throws IOException {
        enderecoDAO.adicionarEndereco(endereco);
    }

    public void atualizarEndereco(Endereco enderecoAtualizado) throws IOException {
        enderecoDAO.atualizarEndereco(enderecoAtualizado);
    }

    public void excluirEndereco(int id) throws IOException {
        enderecoDAO.deletarEndereco(id);
    }
}