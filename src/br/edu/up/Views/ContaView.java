package br.edu.up.Views;

import br.edu.up.Controller.ClienteController;
import br.edu.up.Controller.ContaControler;
import br.edu.up.Modelos.Cliente;

import java.io.IOException;
import java.util.Scanner;

public class ContaView {
    public ContaControler contaController;
    private Scanner scanner;

    public ContaView() throws IOException{
        contaController = new ContaControler();
        scanner = new Scanner(System.in);
    }

    public void view(ClienteController cliente,String doc) throws IOException {
        int opcao = 0;
        do {
            System.out.println("1. Criar Conta");
            System.out.println("2. Buscar Conta");
            System.out.println("3. Encerrar Conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    // criar um cliente antes e atribuir id
                    criarConta(1);
                    break;
                case 2:
                    buscarConta();
                    break;
                case 3:
                    encerrarConta();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    public int criarConta(int cliente) throws IOException {
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Poupança");
        System.out.println("2. Conta Corrente");
        System.out.println("3. Conta Salário");
        System.out.print("Tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Número da conta: ");
        int num_conta = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();   
                
        String resultado = contaController.criar(tipo, num_conta, saldo, cliente);
        System.out.println(resultado);
        return num_conta;
    }

    public void buscarConta() {
        System.out.print("Número da conta: ");
        int num_conta = scanner.nextInt();
        scanner.nextLine();  

        try {
            int numeroConta = contaController.buscar(num_conta);
            System.out.println("Conta encontrada: " + numeroConta);
        } catch (Exception e) {
            System.out.println("Conta não encontrada.");
        }
    }

    public void encerrarConta() {
        System.out.print("Número da conta: ");
        int num_conta = scanner.nextInt();
        scanner.nextLine();  

        try {
            String resultado = contaController.encerrar(num_conta);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Conta não encontrada.");
        }
    }
}
