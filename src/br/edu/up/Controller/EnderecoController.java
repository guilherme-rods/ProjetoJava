package br.edu.up.Controller;

import br.edu.up.DAO.EnderecoDAO;
import br.edu.up.DAO.CidadeDAO;
import br.edu.up.Modelos.Endereco;
import br.edu.up.Views.EnderecoView;
import java.io.IOException;
import java.util.List;

public class EnderecoController {
    private EnderecoDAO enderecoDAO;
    private EnderecoView enderecoView;

    public EnderecoController(String caminhoArquivoEndereco, String caminhoArquivoCidade, EnderecoView view) {
        CidadeDAO cidadeDAO = new CidadeDAO(caminhoArquivoCidade);
        this.enderecoDAO = new EnderecoDAO(caminhoArquivoEndereco, cidadeDAO);
        this.enderecoView = view;
    }

    public void listarEnderecos() throws IOException {
        List<Endereco> enderecos = enderecoDAO.lerEnderecos();
        enderecoView.mostrarEnderecos(enderecos);
    }

    public void adicionarEndereco(Endereco endereco) throws IOException {
        enderecoDAO.adicionarEndereco(endereco);
        enderecoView.mostrarMensagem("\nEndereço adicionado com sucesso!");
    }

    public void atualizarEndereco(Endereco enderecoAtualizado) throws IOException {
        enderecoDAO.atualizarEndereco(enderecoAtualizado);
        enderecoView.mostrarMensagem("\nEndereço atualizado com sucesso!");
    }

    public void excluirEndereco(int id) throws IOException {
        enderecoDAO.deletarEndereco(id);
        enderecoView.mostrarMensagem("\nEndereço excluído com sucesso!");
    }
}