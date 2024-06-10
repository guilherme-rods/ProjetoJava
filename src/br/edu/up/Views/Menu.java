package br.edu.up.Views;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ClienteView clienteView;
    private EnderecoView enderecoView;
    private ContaView contaView;
    private FinanciamentoView financiamentoView;

    public Menu() throws IOException {
        this.scanner = new Scanner(System.in);
        this.clienteView = new ClienteView();
        this.enderecoView = new EnderecoView();
        this.contaView = new ContaView();
        this.financiamentoView = new FinanciamentoView();
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
                    clienteView.AddCliente();
                    enderecoView.adicionarEndereco(1);// id do cliente criado a cima
                    contaView.criarConta(1);// id do cliente a cima
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
                    if(scanner.nextInt()==2){
                        financiamentoView.adicionarFinanciamentoImobiliario();
                    }
                    financiamentoView.adicionarFinanciamentoVeicular();
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
