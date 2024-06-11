package br.edu.up.DAO;

import br.edu.up.Modelos.Cliente;
import br.edu.up.Modelos.ClienteEmpresa;
import br.edu.up.Modelos.ClientePessoa;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private String arquivo;

    public ClienteDAO(String arquivo) {
        this.arquivo = "./dbbanco/" + arquivo;
        initializeFile();
    }

    private void initializeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            if (new File(arquivo).length() == 0) {
                writer.write("id;nome;documento;telefone;tipo;representante;telefone_representante\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> lerClientes() throws IOException {
        List<Cliente> clientes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (linha.startsWith("id")) {
                continue;
            }

            String[] dados = linha.split(";");
            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            String doc = dados[2];
            String telefone = dados[3];
            int tipo = Integer.parseInt(dados[4]);

            switch (tipo) {
                case 1:
                    ClientePessoa cliente = new ClientePessoa(id, nome, telefone, doc);
                    clientes.add(cliente);
                    break;
                case 2:
                    String nomeRepresentante = dados[5];
                    String telefoneRepresentante = dados[6];
                    ClienteEmpresa clienteEmpresa = new ClienteEmpresa(id, nome, telefone, doc, nomeRepresentante, telefoneRepresentante);
                    clientes.add(clienteEmpresa);
                    break;
                default:
                    break;
            }
        }
        br.close();
        return clientes;
    }

    public void salvar(List<Cliente> clientes) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write("id;nome;documento;telefone;tipo;representante;telefone_representante\n");
        for (Cliente cliente : clientes) {
            bw.write(cliente.ToStringCSV() + "\n");
        }
        bw.close();
    }

    public void adicionar(Cliente cliente) throws IOException {
        List<Cliente> clientes = lerClientes();
        clientes.add(cliente);
        salvar(clientes);
    }
}
