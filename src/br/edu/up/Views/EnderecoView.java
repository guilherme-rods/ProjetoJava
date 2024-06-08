package br.edu.up.Views;

import br.edu.up.Controller.EnderecoController;
import br.edu.up.Modelos.Endereco;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EnderecoView {
    private Scanner scanner;
    private EnderecoController enderecoController;

    public EnderecoView() {
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    public void setController(EnderecoController controller) {
        this.enderecoController = controller;
    }

    public void exibirMenu() throws IOException {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu de Endereços:");
            System.out.println("1. Listar Endereços");
            System.out.println("2. Adicionar Endereço");
            System.out.println("3. Atualizar Endereço");
            System.out.println("4. Excluir Endereço");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    listarEnderecos();
                    break;
                case 2:
                    adicionarEndereco();
                    break;
                case 3:
                    atualizarEndereco();
                    break;
                case 4:
                    excluirEndereco();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    mostrarMensagem("\n** Opção inválida! **");
            }
        }
    }

    public void listarEnderecos() throws IOException {
        enderecoController.listarEnderecos();
    }

    public void adicionarEndereco() throws IOException {
        Endereco endereco = obterDadosEndereco();
        enderecoController.adicionarEndereco(endereco);
    }

    public void atualizarEndereco() throws IOException {
        int id = obterIdEndereco();
        Endereco enderecoAtualizado = obterDadosEndereco();
        enderecoAtualizado.setId(id);
        enderecoController.atualizarEndereco(enderecoAtualizado);
    }

    public void excluirEndereco() throws IOException {
        int id = obterIdEndereco();
        enderecoController.excluirEndereco(id);
    }

    public void mostrarEnderecos(List<Endereco> enderecos) {
        for (Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
    }

    public Endereco obterDadosEndereco() {
        System.out.print("\nInforme o CEP: ");
        String cep = scanner.nextLine().trim();
        
        System.out.print("Informe o Estado: ");
        String estado = scanner.nextLine().trim();
        
        System.out.print("Informe a Cidade: ");
        String cidade = scanner.nextLine().trim();
        
        System.out.print("Informe o Bairro: ");
        String bairro = scanner.nextLine().trim();
        
        System.out.print("Informe o Logradouro: ");
        String logradouro = scanner.nextLine().trim();
        
        System.out.print("Informe o Número Residencial: ");
        String numero = scanner.nextLine().trim();
        System.out.print("");

        return new Endereco(0, cep, estado, cidade, bairro, logradouro, numero);
    }

    public int obterIdEndereco() {
        System.out.print("\nInforme o ID do Endereço: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha
        return id;
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
