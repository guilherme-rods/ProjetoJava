package br.edu.up.DAO;

import br.edu.up.Modelos.Endereco;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private String arquivo;
    private String header = "CEP;Estado;Cidade;Bairro;Logradouro;NumeroResidencial";

    public EnderecoDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Endereco> lerEnderecos() throws IOException {
        List<Endereco> enderecos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("CEP")) // Ignora o cabeçalho
                    continue;

                String[] dados = linha.split(";");
                String cep = dados[0];
                String estado = dados[1];
                String cidade = dados[2];
                String bairro = dados[3];
                String logradouro = dados[4];
                String num_residencial = dados[5];

                Endereco endereco = new Endereco(cep, estado, cidade, bairro, logradouro, num_residencial);
                enderecos.add(endereco);
            }
        }
        return enderecos;
    }

    public void salvarEnderecos(List<Endereco> enderecos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write(header + "\n");
            for (Endereco endereco : enderecos) {
                bw.write(toStringCsv(endereco) + "\n");
            }
        }
    }

    public void adicionarEndereco(Endereco endereco) throws IOException {
        List<Endereco> enderecos = lerEnderecos();
        enderecos.add(endereco);
        salvarEnderecos(enderecos);
    }

    public void atualizarEndereco(Endereco enderecoAtualizado) throws IOException {
        List<Endereco> enderecos = lerEnderecos();
        for (int i = 0; i < enderecos.size(); i++) {
            Endereco endereco = enderecos.get(i);
            if (endereco.getCep().equals(enderecoAtualizado.getCep())) {
                enderecos.set(i, enderecoAtualizado);
                break;
            }
        }
        salvarEnderecos(enderecos);
    }

    public void deletarEndereco(String cep) throws IOException {
        List<Endereco> enderecos = lerEnderecos();
        enderecos.removeIf(endereco -> endereco.getCep().equals(cep));
        salvarEnderecos(enderecos);
    }

    private String toStringCsv(Endereco endereco) {
        return endereco.getCep() + ";" + 
               endereco.getEstado() + ";" + 
               endereco.getCidade() + ";" + 
               endereco.getBairro() + ";" + 
               endereco.getLogradouro() + ";" + 
               endereco.getNumero_residencial();
    }
}