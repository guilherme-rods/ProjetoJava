package br.edu.up.DAO;

import br.edu.up.Modelos.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvDAO {
    private String arquivo;

    public CsvDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Registro> lerRegistros() throws IOException {
        List<Registro> registros = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("id")) continue; 
            String[] dados = linha.split(";");
            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            int idade = Integer.parseInt(dados[2]);
            registros.add(new Registro(id, nome, idade));
        }
        br.close();
        return registros;
    }

    public void salvarRegistros(List<Registro> registros, String headder) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(headder + "\n");
        for (Registro registro : registros) {
            bw.write(registro.toString() + "\n");
        }
        bw.close();
    }

    public void adicionarRegistro(Registro registro, String headder) throws IOException {
        List<Registro> registros = lerRegistros();
        registros.add(registro);
        salvarRegistros(registros, headder);
    }

    public void atualizarRegistro(Registro registroAtualizado,String headder) throws IOException {
        List<Registro> registros = lerRegistros();
        for (Registro registro : registros) {
            if (registro.getId() == registroAtualizado.getId()) {
                registro.setNome(registroAtualizado.getNome());
                registro.setIdade(registroAtualizado.getIdade());
                break;
            }
        }
        salvarRegistros(registros, headder);
    }

    public void deletarRegistro(int id,String headder) throws IOException {
        List<Registro> registros = lerRegistros();
        registros.removeIf(registro -> registro.getId() == id);
        salvarRegistros(registros,headder);
    }
}
