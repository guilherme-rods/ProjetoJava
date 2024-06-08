package br.edu.up.DAO;

import br.edu.up.Modelos.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private String arquivo;

    public ContaDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
    }

    public List<Conta> lerContas() throws IOException {

        List<Conta> contas = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        String linha;

        while ((linha = br.readLine()) != null) {

            if (linha.startsWith("num_conta"))
                continue;

            String[] dados = linha.split(";");
            int numconta = Integer.parseInt(dados[0]);
            int tipo = Integer.parseInt(dados[1]);
            double saldo = Double.parseDouble(dados[2]);
            int cliente_id = Integer.parseInt(dados[3]);

            switch (tipo) {
                case 1:
                    ContaCorrente contac = new ContaCorrente(numconta, saldo, cliente_id);
                    Double limite = Double.parseDouble(dados[4]);
                    contac.setLimiteChequeEspecial(limite);
                    contas.add(contac);

                    break;
                case 2:

                    ContaPoupanca contap = new ContaPoupanca(numconta, saldo, cliente_id);
                    Double rendimento = Double.parseDouble(dados[4]);
                    contap.setRendimentoMensal(rendimento);
                    contas.add(contap);
                    break;
                case 3:
                    contas.add(new ContaSalario(numconta, saldo, cliente_id));
                    break;
                default:
                    break;
            }

        }
        br.close();
        return contas;
    }

    public void salvarContas(List<Conta> contas, String headder) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(headder + "\n");
        for (Conta conta : contas) {
            bw.write(conta.ToStringCSV() + "\n");
        }
        bw.close();
    }

    public void adicionarConta(Conta conta, String headder) throws IOException {
        List<Conta> contas = lerContas();
        contas.add(conta);
        salvarContas(contas, headder);
    }

    public void atualizarConta(Conta contaAtualizada, String headder) throws IOException {
        List<Conta> contas = lerContas();
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            if (conta.getNum_conta() == contaAtualizada.getNum_conta()) {
                contas.set(i, contaAtualizada);
                break;
            }
        }
        salvarContas(contas, headder);
    }

    public void deletarConta(int num_conta, String headder) throws IOException {
        List<Conta> contas = lerContas();
        contas.removeIf(conta -> conta.getNum_conta() == num_conta);
        salvarContas(contas, headder);
    }
}