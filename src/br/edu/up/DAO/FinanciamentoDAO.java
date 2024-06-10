package br.edu.up.DAO;

import br.edu.up.Modelos.Financiamento;
import br.edu.up.Modelos.FinanciamentoImobiliario;
import br.edu.up.Modelos.FinanciamentoVeicular;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanciamentoDAO {
    private String arquivo;
    private String header = "id;tipoFinanciamento;valor;prazo;tipoImovel;taxaJurosAnual;tipoVeiculo;anoFabricacao;taxaJurosMensal";

    public FinanciamentoDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Financiamento> lerFinanciamentos() throws IOException {
        List<Financiamento> financiamentos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        br.readLine();
        
        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(";");
            int id = Integer.parseInt(dados[0]);
            int tipoFinanciamento = Integer.parseInt(dados[1]);
            double valor = Double.parseDouble(dados[2]);
            int prazo = Integer.parseInt(dados[3]);

            if (tipoFinanciamento == 1) {
                String tipoImovel = dados[4];
                double taxaJurosAnual = Double.parseDouble(dados[5]);
                FinanciamentoImobiliario financiamentoImobiliario = new FinanciamentoImobiliario(id, valor, prazo, tipoImovel, taxaJurosAnual);
                financiamentos.add(financiamentoImobiliario);
            } else if (tipoFinanciamento == 2) {
                String tipoVeiculo = dados[6];
                int anoFabricacao = Integer.parseInt(dados[7]);
                double taxaJurosMensal = Double.parseDouble(dados[8]);
                FinanciamentoVeicular financiamentoVeicular = new FinanciamentoVeicular(id, valor, prazo, tipoVeiculo, anoFabricacao, taxaJurosMensal);
                financiamentos.add(financiamentoVeicular);
            }
        }
        br.close();
        return financiamentos;
    }

    public void salvarFinanciamentos(List<Financiamento> financiamentos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(header + "\n");
        for (Financiamento financiamento : financiamentos) {
            if (financiamento instanceof FinanciamentoImobiliario) {
                FinanciamentoImobiliario fi = (FinanciamentoImobiliario) financiamento;
                bw.write(fi.getId() + ";" + fi.tipoFinanciamento + ";" + fi.getValor() + ";" + fi.getPrazo() + ";" + fi.getTipoImovel() + ";" + fi.getTaxaJurosAnual() + ";;;\n");
            } else if (financiamento instanceof FinanciamentoVeicular) {
                FinanciamentoVeicular fv = (FinanciamentoVeicular) financiamento;
                bw.write(fv.getId() + ";" + fv.tipoFinanciamento + ";" + fv.getValor() + ";" + fv.getPrazo() + ";;;" + fv.getTipoVeiculo() + ";" + fv.getAnoFabricacao() + ";" + fv.getTaxaJurosMensal() + "\n");
            }
        }
        bw.close();
    }

    public void adicionarFinanciamento(Financiamento financiamento) throws IOException {
        List<Financiamento> financiamentos = lerFinanciamentos();
        financiamentos.add(financiamento);
        salvarFinanciamentos(financiamentos);
    }

    public void atualizarFinanciamento(Financiamento financiamentoAtualizado) throws IOException {
        List<Financiamento> financiamentos = lerFinanciamentos();
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            if (financiamento.getId() == financiamentoAtualizado.getId()) {
                financiamentos.set(i, financiamentoAtualizado);
                break;
            }
        }
        salvarFinanciamentos(financiamentos);
    }

    public void deletarFinanciamento(int id) throws IOException {
        List<Financiamento> financiamentos = lerFinanciamentos();
        financiamentos.removeIf(financiamento -> financiamento.getId() == id);
        salvarFinanciamentos(financiamentos);
    }
}
