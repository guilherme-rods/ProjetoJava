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

            if (linha.startsWith("id"))
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

    public void salvarRegistros(List<Registro> registros, String headder) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(headder + "\n");
        for (Registro registro : registros) {
            bw.write(registro.toString() + "\n");
        }
        bw.close();
    }

    // public void adicionarRegistro(Registro registro, String headder) throws
    // IOException {
    // List<Registro> registros = lerRegistros();
    // registros.add(registro);
    // salvarRegistros(registros, headder);
    // }

    // public void atualizarRegistro(Registro registroAtualizado,String headder)
    // throws IOException {
    // List<Registro> registros = lerRegistros();
    // for (Registro registro : registros) {
    // if (registro.getId() == registroAtualizado.getId()) {
    // registro.setNome(registroAtualizado.getNome());
    // registro.setIdade(registroAtualizado.getIdade());
    // break;
    // }
    // }
    // salvarRegistros(registros, headder);
    // }

    // public void deletarRegistro(int id,String headder) throws IOException {
    // List<Registro> registros = lerRegistros();
    // registros.removeIf(registro -> registro.getId() == id);
    // salvarRegistros(registros,headder);
    // }
}
