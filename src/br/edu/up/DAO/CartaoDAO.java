package br.edu.up.DAO;

import br.edu.up.Modelos.Cartao;
import br.edu.up.Modelos.CartaoCredito;
import br.edu.up.Modelos.CartaoDebito;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartaoDAO {
    private String arquivo;
    private final String header = "idCartao;tipoCartao;num_cartao;num_conta;validade;bandeira;limite;saldoUtilizado;saldo";

    public CartaoDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Cartao> lerCartoes() throws IOException {
        List<Cartao> cartoes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("idCartao"))
                continue;

            String[] dados = linha.split(";");
            int idCartao = Integer.parseInt(dados[0]);
            int tipoCartao = Integer.parseInt(dados[1]);
            int numCartao = Integer.parseInt(dados[2]);
            int numConta = Integer.parseInt(dados[3]);
            Date validade = parseDate(dados[4]);
            String bandeira = dados[5];

            if (tipoCartao == 1) { // Cartão de Crédito
                double limite = Double.parseDouble(dados[6]);
                double saldoUtilizado = Double.parseDouble(dados[7]);
                CartaoCredito cartaoCredito = new CartaoCredito(idCartao, numCartao, numConta, validade, bandeira, tipoCartao, limite, saldoUtilizado);
                cartoes.add(cartaoCredito);
            } else if (tipoCartao == 2) { // Cartão de Débito
                double saldo = Double.parseDouble(dados[8]);
                CartaoDebito cartaoDebito = new CartaoDebito(idCartao, numCartao, numConta, validade, bandeira, tipoCartao, saldo);
                cartoes.add(cartaoDebito);
            }
        }
        br.close();
        return cartoes;
    }

    public void salvarCartoes(List<Cartao> cartoes) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(header + "\n");
        for (Cartao cartao : cartoes) {
            bw.write(cartaoToStringCSV(cartao) + "\n");
        }
        bw.close();
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
            return formatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
        return formatter.format(date);
    }

    private String cartaoToStringCSV(Cartao cartao) {
        if (cartao instanceof CartaoCredito) {
            CartaoCredito cc = (CartaoCredito) cartao;
            return cc.getIdCartao() + ";" +
                    cc.getTipoCartao() + ";" +
                    cc.getNum_cartao() + ";" +
                    cc.getNum_conta() + ";" +
                    formatDate(cc.getValidade()) + ";" +
                    cc.getBandeira() + ";" +
                    cc.getLimite() + ";" +
                    cc.getSaldoUtilizado() + ";";
        } else if (cartao instanceof CartaoDebito) {
            CartaoDebito cd = (CartaoDebito) cartao;
            return cd.getIdCartao() + ";" +
                    cd.getTipoCartao() + ";" +
                    cd.getNum_cartao() + ";" +
                    cd.getNum_conta() + ";" +
                    formatDate(cd.getValidade()) + ";" +
                    cd.getBandeira() + ";;;;" +
                    cd.getSaldo();
        }
        return "";
    }
}
