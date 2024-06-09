package br.edu.up.Views;

import br.edu.up.Controller.ClienteController;
import br.edu.up.Modelos.ClienteEmpresa;
import br.edu.up.Modelos.ClientePessoa;
import br.edu.up.Modelos.Endereco;

import java.util.Scanner;

public class ClienteView {
    private ClienteController _controller;
    private Scanner _scanner;

    public ClienteView() {
        _controller = new ClienteController();
        _scanner = new Scanner(System.in);
    }

    public void AddCliente() {
        System.out.println("Digite os dados do cliente");
        System.out.println("Nome");
        var nome = _scanner.nextLine();

        System.out.println("Documento");
        var doc = _scanner.nextLine();

        System.out.println("Telefone");
        var telefone = _scanner.nextLine();

        int opcao;
        do {
            System.out.println("Qual será o tipo de cliente?");
            System.out.println("1) Pessoa Física");
            System.out.println("2) Pessoa Jurídica");
            opcao = _scanner.nextInt();
            _scanner.nextLine();
            if(opcao != 1 && opcao != 2){
                System.err.println("Opção inválida!");
            }
        } while (opcao != 1 && opcao != 2);

        var representante = "";
        var tel_representante = "";
        if(opcao == 2) {
            System.out.println("Nome do representante");
            representante = _scanner.nextLine();

            System.out.println("Telefone do representante");
            tel_representante = _scanner.nextLine();
        }

        var cliente = opcao == 1
                ? new ClientePessoa(nome, telefone, doc)
                : new ClienteEmpresa(nome, telefone, doc, representante, tel_representante);

        var position = _controller.AddCliente(cliente);

        do {
            System.out.println("Adicionar endereço?");
            System.out.println("1) Sim");
            System.out.println("2) Não");

            opcao = _scanner.nextInt();
            _scanner.nextLine();

            if(opcao != 1 && opcao != 2){
                System.err.println("Opção inválida!");
            }
        } while (opcao != 1 && opcao != 2);

        if(opcao == 1){
            System.out.println("Insira os dados do endereço");
            System.out.println("CEP");
            var cep = _scanner.nextLine();

            System.out.println("Estado");
            var estado = _scanner.nextLine();

            System.out.println("Cidade");
            var cidade = _scanner.nextLine();

            System.out.println("Bairro");
            var bairro = _scanner.nextLine();

            System.out.println("Logradouro");
            var logradouro = _scanner.nextLine();

            System.out.println("Número");
            var numero = _scanner.nextLine();

            var endereco = new Endereco(cep, estado, cidade, bairro, logradouro, numero);
            _controller.AddEndereco(position, endereco);
        }

        System.out.println("Cliente adicionado");
    }

    public void Edit() {
        System.out.println("Digite o documento do cliente que quer editar");

        try {
            var cliente = _controller.Get(_scanner.nextLine());
            System.out.println(cliente);

            System.out.println("Qual campo você quer editar?");
            System.out.println("1) Nome");
            System.out.println("2) Documento");
            System.out.println("3) Telefone");
            if(cliente instanceof ClienteEmpresa){

                System.out.println("4) Nome representante");
                System.out.println("5) Telefone representante");
            }

            var opcaoEscolhida = _scanner.nextInt();
            _scanner.nextLine();

            if(cliente instanceof ClientePessoa && (opcaoEscolhida == 4 || opcaoEscolhida == 5)){
                throw new IllegalArgumentException("Opção escolhida inválida!");
            }

            switch (opcaoEscolhida) {
                case 1:
                    System.out.println("Digite o nome");
                    cliente.setNome(_scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo documento");
                    cliente.setDocumento(_scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Digite o telefone");
                    cliente.setTelefone(_scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Digite o nome do representante");
                    assert cliente instanceof ClienteEmpresa;
                    ((ClienteEmpresa) cliente).setNome_representante(_scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Digite o telefone do representante");
                    assert cliente instanceof ClienteEmpresa;
                    ((ClienteEmpresa) cliente).setTelefoneRepresentante(_scanner.nextLine());
                    break;
                default:
                    throw new IllegalArgumentException("Opção escolhida inválida!");
            }

            _controller.Update(cliente);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}
