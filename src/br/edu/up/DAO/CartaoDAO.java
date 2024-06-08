package br.edu.up.DAO;

import br.edu.up.Modelos.Cartao;
import br.edu.up.Modelos.Cliente;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartaoDAO {
    private String arquivo;

    public CartaoDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Cartao> lerCartoes() throws IOException {
        List<Cartao> cartoes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("num_cartao"))
                continue;

            String[] dados = linha.split(";");
            int numCartao = Integer.parseInt(dados[0]);
            int codValidacao = Integer.parseInt(dados[1]);
            Date validade = parseDate(dados[2]);
            int cliente = Integer.parseInt(dados[3]); // Assumindo que o nome do cliente está na posição 3
            String bandeira = dados[4];
            boolean titular = Boolean.parseBoolean(dados[5]);
            boolean bloqueado = Boolean.parseBoolean(dados[6]);
            double limCredito = Double.parseDouble(dados[7]);
            String tipoOperacao = dados[8];
            Date emissao = parseDate(dados[9]);
            Date vencimento = parseDate(dados[10]);

            Cartao cartao = new Cartao(numCartao, codValidacao, validade, cliente, bandeira, titular, bloqueado, limCredito, tipoOperacao, emissao, vencimento);
            cartoes.add(cartao);
        }
        br.close();
        return cartoes;
    }

    public void salvarCartoes(List<Cartao> cartoes) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write("num_cartao;cod_validacao;validade;cliente;bandeira;titular;bloqueado;lim_credito;tipo_operacao;emissao;vencimento\n");
        for (Cartao cartao : cartoes) {
            bw.write(cartaoToStringCSV(cartao) + "\n");
        }
        bw.close();
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    private String cartaoToStringCSV(Cartao cartao) {
        return cartao.getNum_cartao() + ";" +
                cartao.getCod_validacao() + ";" +
                formatDate(cartao.getValidade()) + ";" +
                cartao.getCliente() + ";" +
                cartao.getBandeira() + ";" +
                cartao.isTitular() + ";" +
                cartao.isBloqueado() + ";" +
                cartao.getLim_credito() + ";" +
                cartao.getTipo_operacao() + ";" +
                formatDate(cartao.getEmissao()) + ";" +
                formatDate(cartao.getVencimento());
    }
}
