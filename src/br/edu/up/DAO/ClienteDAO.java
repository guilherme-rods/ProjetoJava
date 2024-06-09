package br.edu.up.DAO;

import br.edu.up.Modelos.Cliente;
import br.edu.up.Modelos.ClientePessoa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClienteDAO{
    public static void main(String[] args) {
      ClienteDAO obj = new ClienteDAO();
      obj.run();
    }
 public void run(){
  String arquivoCsv = "clientes.csv";
  BufferedReader br = null;
  String linha = "";
  String csvDivisor = ",";
  try {
    br = new BufferedReader(new FileReader(arquivoCsv));
    while ((linha = br.readLine()) != null) {
      String[] dados = linha.split(csvDivisor);
      System.out.println("Dados: nome: " + dados[dados.length - 2] + ", telefone: " + dados[dados.length - 1]) + "."; 

    }
  }


}

 


}


// public class ClienteDAO {
//   private static final String CSV_FILE = "clientes.csv";

//   public void addCliente(Cliente cliente) throws IOException {
//     try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true))){

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
