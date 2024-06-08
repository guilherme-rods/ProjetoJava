package br.edu.up.DAO;

import br.edu.up.Modelos.Financiamento;
import br.edu.up.Modelos.FinanciamentoImobiliario;
import br.edu.up.Modelos.FinanciamentoVeicular;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanciamentoDAO {
    private String arquivo;
    private String headder = "";

    public FinanciamentoDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Financiamento> lerFinanciamentos() throws IOException {
        List<Financiamento> financiamentos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("Categoria"))
                continue;

            String[] dados = linha.split(";");
            int categoria = Integer.parseInt(dados[0]);
            int numContrato = Integer.parseInt(dados[1]);
            double valorFinanciamento = Double.parseDouble(dados[2]);

            switch (categoria) {
                case 1:
                    FinanciamentoImobiliario financiamentoImobiliario = new FinanciamentoImobiliario(categoria, numContrato, valorFinanciamento);
                    financiamentos.add(financiamentoImobiliario);
                    break;
                case 2:
                    FinanciamentoVeicular financiamentoVeicular = new FinanciamentoVeicular(categoria, numContrato, valorFinanciamento);
                    financiamentos.add(financiamentoVeicular);
                    break;
                default:
                    break;
            }
        }
        br.close();
        return financiamentos;
    }

    public void salvarFinanciamentos(List<Financiamento> financiamentos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(headder + "\n");
        for (Financiamento financiamento : financiamentos) {
            bw.write(financiamento.toString() + "\n");
        }
        bw.close();
    }

    public void adicionarFinanciamento(Financiamento financiamento, String headder) throws IOException {
        List<Financiamento> financiamentos = lerFinanciamentos();
        financiamentos.add(financiamento);
        salvarFinanciamentos(financiamentos);
    }

    public void atualizarFinanciamento(Financiamento financiamentoAtualizado, String headder) throws IOException {
        List<Financiamento> financiamentos = lerFinanciamentos();
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            if (financiamento.getNumContrato() == financiamentoAtualizado.getNumContrato()) {
                financiamentos.set(i, financiamentoAtualizado);
                break;
            }
        }
        salvarFinanciamentos(financiamentos);
    }

    public void deletarFinanciamento(int numContrato, String headder) throws IOException {
        List<Financiamento> financiamentos = lerFinanciamentos();
        financiamentos.removeIf(financiamento -> financiamento.getNumContrato() == numContrato);
        salvarFinanciamentos(financiamentos);
    }
}
