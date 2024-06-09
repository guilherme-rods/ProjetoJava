package br.edu.up.DAO;

import br.edu.up.Modelos.Endereco;
import br.edu.up.Modelos.Cidade;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private String arquivo;
    private String header = "ID;CEP;Estado;CidadeID;Bairro;Logradouro;NumeroResidencial";
    private CidadeDAO cidadeDAO;

    public EnderecoDAO(String arquivo, CidadeDAO cidadeDAO) {
        this.arquivo = "./dbbanco/" + arquivo;
        this.cidadeDAO = cidadeDAO;
    }

    public List<Endereco> lerEnderecos() throws IOException {
        List<Endereco> enderecos = new ArrayList<>();
        List<Cidade> cidades = cidadeDAO.lerCidades();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(arquivo), StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("ID")) // Ignora o cabeçalho
                    continue;

                String[] dados = linha.split(";");
                if (dados.length < 7) {
                    continue; // Ignora linhas que não têm o número correto de campos
                }

                try {
                    int id = Integer.parseInt(dados[0]);
                    String cep = dados[1];
                    String estado = dados[2];
                    int cidadeId = Integer.parseInt(dados[3]);
                    String bairro = dados[4];
                    String logradouro = dados[5];
                    String num_residencial = dados[6];

                    Cidade cidade = cidades.stream().filter(c -> c.getCod() == cidadeId).findFirst().orElse(null);
                    if (cidade != null) {
                        Endereco endereco = new Endereco(id, cep, estado, cidade.getNome(), bairro, logradouro,
                                num_residencial);
                        enderecos.add(endereco);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\nErro ao converter valor: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return enderecos;
    }

    public void salvarEnderecos(List<Endereco> enderecos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(arquivo), StandardCharsets.UTF_8))) {
            bw.write(header + "\n");
            for (Endereco endereco : enderecos) {
                Cidade cidade = validarCidade(endereco.getCidade());
                String enderecoCsv = toStringCsv(endereco, cidade.getCod());
                bw.write(enderecoCsv + "\n");
            }
        }
    }

    public void adicionarEndereco(Endereco endereco) throws IOException {
        List<Endereco> enderecos = lerEnderecos();
        int novoId = enderecos.isEmpty() ? 1 : enderecos.get(enderecos.size() - 1).getId() + 1;
        Cidade cidade = validarCidade(endereco.getCidade());
        Endereco novoEndereco = new Endereco(novoId, endereco.getCep(), endereco.getEstado(), cidade.getNome(),
                endereco.getBairro(), endereco.getLogradouro(), endereco.getNumero_residencial());
        enderecos.add(novoEndereco);
        salvarEnderecos(enderecos);
    }

    public void atualizarEndereco(Endereco enderecoAtualizado) throws IOException {
        List<Endereco> enderecos = lerEnderecos();
        for (int i = 0; i < enderecos.size(); i++) {
            Endereco endereco = enderecos.get(i);
            if (endereco.getId() == enderecoAtualizado.getId()) {
                Cidade cidade = validarCidade(enderecoAtualizado.getCidade());
                enderecos.set(i,
                        new Endereco(enderecoAtualizado.getId(), enderecoAtualizado.getCep(),
                                enderecoAtualizado.getEstado(), cidade.getNome(), enderecoAtualizado.getBairro(),
                                enderecoAtualizado.getLogradouro(), enderecoAtualizado.getNumero_residencial()));
                break;
            }
        }
        salvarEnderecos(enderecos);
    }

    public void deletarEndereco(int id) throws IOException {
        List<Endereco> enderecos = lerEnderecos();
        enderecos.removeIf(endereco -> endereco.getId() == id);
        // Reajustar IDs
        for (int i = 0; i < enderecos.size(); i++) {
            Endereco endereco = enderecos.get(i);
            endereco.setId(i + 1);
        }
        salvarEnderecos(enderecos);
    }

    private Cidade validarCidade(String nomeCidade) throws IOException {
        List<Cidade> cidades = cidadeDAO.lerCidades();
        String nomeCidadeNormalizado = normalizarTexto(nomeCidade);

        for (Cidade cidade : cidades) {
            if (normalizarTexto(cidade.getNome()).equals(nomeCidadeNormalizado)) {
                return cidade;
            }
        }
        throw new IOException("\nCidade não encontrada: " + nomeCidade);
    }

    private String normalizarTexto(String texto) {
        texto = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        texto = texto.replaceAll("[^\\p{ASCII}]", "");
        return texto.toLowerCase();
    }

    private String toStringCsv(Endereco endereco, int cidadeId) {
        return endereco.getId() + ";" +
                endereco.getCep() + ";" +
                endereco.getEstado() + ";" +
                cidadeId + ";" +
                endereco.getBairro() + ";" +
                endereco.getLogradouro() + ";" +
                endereco.getNumero_residencial();
    }
}