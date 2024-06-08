package br.edu.up.DAO;

import br.edu.up.Modelos.Cidade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    private String arquivo;
    private String header = "Nome;Estado";

    public CidadeDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Cidade> lerCidades() throws IOException {
        List<Cidade> cidades = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("cod_cidade"))
                    continue;

                String[] dados = linha.split(";");
                int cod_cidade = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String estado = dados[2];

                Cidade cidade = new Cidade();

                cidade.setCod(cod_cidade);
                cidade.setNome(nome);
                cidade.setEstado(estado);
                cidades.add(cidade);
            }
        }
        return cidades;
    }

    public void salvarCidades(List<Cidade> cidades) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write(header + "\n");
            for (Cidade cidade : cidades) {
                bw.write(toStringCsv(cidade) + "\n");
            }
        }
    }

    public void adicionarCidade(Cidade cidade) throws IOException {
        List<Cidade> cidades = lerCidades();
        cidades.add(cidade);
        salvarCidades(cidades);
    }

    public void atualizarCidade(Cidade cidadeAtualizada) throws IOException {
        List<Cidade> cidades = lerCidades();
        for (int i = 0; i < cidades.size(); i++) {
            Cidade cidade = cidades.get(i);
            if (cidade.getNome().equals(cidadeAtualizada.getNome()) &&
                    cidade.getEstado().equals(cidadeAtualizada.getEstado())) {
                cidades.set(i, cidadeAtualizada);
                break;
            }
        }
        salvarCidades(cidades);
    }

    public void deletarCidade(String nome, String estado) throws IOException {
        List<Cidade> cidades = lerCidades();
        cidades.removeIf(cidade -> cidade.getNome().equals(nome) && cidade.getEstado().equals(estado));
        salvarCidades(cidades);
    }

    private String toStringCsv(Cidade cidade) {
        return cidade.getCod() + ";" + cidade.getNome() + ";" + cidade.getEstado();
    }
}
