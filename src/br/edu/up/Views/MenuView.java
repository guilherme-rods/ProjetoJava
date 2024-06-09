package br.edu.up.Views;

// import br.edu.up.Controller.ClienteController;
// import br.edu.up.Controller.ContaControler;
import br.edu.up.Controller.EnderecoController;
import java.io.IOException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() throws IOException {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Contas");
            System.out.println("3. Gerenciar Endereços");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    ClienteView clienteView = new ClienteView();
                    clienteView.exibirMenu();
                    break;
                case 2:
                    ContaView contaView = new ContaView();
                    contaView.exibirMenu();
                    break;
                case 3:
                    EnderecoView enderecoView = new EnderecoView();
                    EnderecoController enderecoController = new EnderecoController("enderecos.csv", "cidades.csv", enderecoView);
                    enderecoView.setController(enderecoController);
                    enderecoView.exibirMenu();
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
