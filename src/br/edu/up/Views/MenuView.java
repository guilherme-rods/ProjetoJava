package br.edu.up.Views;
import br.edu.up.Controller.ClienteController;
import java.io.IOException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private ClienteView clienteView;
    private EnderecoView enderecoView;
    private ContaView contaView;

    public MenuView() throws IOException {
        this.scanner = new Scanner(System.in);
        this.clienteView = new ClienteView();
        this.enderecoView = new EnderecoView();
        this.contaView = new ContaView();
    }

    public void exibirMenu() throws IOException {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Criar conta");
            System.out.println("2. Buscar conta");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int idCliente = clienteView.AddCliente();
                    enderecoView.adicionarEndereco();
                    // clienteController.getCliente();
                    int id_conta = contaView.criarConta(idCliente);// id do cliente a cima
                    // cartaoview  id da conta no cartão
                    break;
                case 2:
                   contaView.buscarConta();
                    break;
                case 3:
                    clienteView.Edit();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
