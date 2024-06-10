package br.edu.up.Views;
import java.io.IOException;
import java.util.Scanner;

import br.edu.up.Controller.ClienteController;

public class MenuView {
    private Scanner scanner;
    private ClienteView clienteView;
    private EnderecoView enderecoView;
    private ContaView contaView;
    private FinanciamentoView financiamentoView;
    private ClienteController clienteController;

    public MenuView() throws IOException {
        this.scanner = new Scanner(System.in);
        this.clienteView = new ClienteView();
        this.enderecoView = new EnderecoView();
        this.contaView = new ContaView();
        this.financiamentoView = new FinanciamentoView();
        this.clienteController = new ClienteController();
    }

    public void exibirMenu() throws IOException {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Criar conta");
            System.out.println("2. Buscar conta");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Atualizar conta");
            System.out.println("5. Adquirir financiamento");
            System.out.println("6. Atualizar financiamento");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int idCliente = clienteView.AddCliente();
                    enderecoView.adicionarEndereco();
                    // clienteController.getCliente();
                    contaView.criarConta(idCliente);// id do cliente a cima
                    // cartaoview  id da conta no cartão
                    break;
                case 2:
                   contaView.buscarConta();
                    break;
                case 3:
                clienteView.Edit();
                    break;
                case 4:
                    // eidtar conta que inclui editar endereço e dados do cliente ou adicionar cartão extra etc...
                    break;
                case 5:
                    System.out.println("que tipo de financiamento pretende?\n");
                    System.out.println("1 - Veicular\n2 - Imobiliario");
                    int opt = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Qual seu Documento?");
                    String doc = scanner.nextLine();
                    if(opt ==2){
                        financiamentoView.adicionarFinanciamentoImobiliario(clienteView.buscarIdCliente(doc));
                    }
                    financiamentoView.adicionarFinanciamentoVeicular(clienteView.buscarIdCliente(doc));
                    break;
                case 6:
                    financiamentoView.menu();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
