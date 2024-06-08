// package br.edu.up.DAO;

// import br.edu.up.Modelos.Cliente;
// import br.edu.up.Modelos.ClientePessoa;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;

// public class ClienteDAO {
//   private static final String CSV_FILE = "clientes.csv";

//   public void adicionarCliente(Cliente cliente) throws IOException {
//     try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
//       writer.println(cliente.toString());
//     }
//   }

//   public List<Cliente> listarClientes() throws IOException {
//     List<Cliente> clientes = new ArrayList<Cliente>();
//     try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))){
//       String linha;
//       while ((linha = reader.readLine()) != null){
//         String[] dados = linha.split(", ");
//         String nome = dados[0].split("=")[1];
//         String cpf = dados[1].split("=")[1];
//         String telefone = dados[2].split("=")[1];
//         String endereco = dados[3].split("=")[1].replace("]", "");
//         clientes.add(new ClientePessoa(nome, telefone, cpf));
//       }
//       return clientes;
//     }
//   }
// }
