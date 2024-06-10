package br.edu.up.Views;

import br.edu.up.Controller.FinanciamentoController;
import br.edu.up.Modelos.FinanciamentoImobiliario;
import br.edu.up.Modelos.FinanciamentoVeicular;

import java.util.Scanner;

public class FinanciamentoView {

    private FinanciamentoController controller;
    private Scanner scanner;

    public FinanciamentoView() {
        this.controller = new FinanciamentoController();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("Menu de Financiamentos:");
            System.out.println("1. Visualizar Prazo Total");
            System.out.println("2. Visualizar Parcelas Pagas");
            System.out.println("3. Visualizar Saldo a Pagar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    visualizarPrazoTotal();
                    break;
                case 2:
                    visualizarParcelasPagas();
                    break;
                case 3:
                    visualizarSaldoAPagar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void adicionarFinanciamentoImobiliario(int idCliente) {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        System.out.print("Digite o valor do financiamento: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite o Prazo do financimento (em meses): ");
        int prazo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Qual é o tipo de imóvel a ser financiado? ");
        String tipoImovel = scanner.nextLine();
        System.out.print("Qual é a taxa de juros anual? ");
        double taxaJurosAnual = scanner.nextDouble();

        FinanciamentoImobiliario financiamento = new FinanciamentoImobiliario(id, valor, prazo, tipoImovel, taxaJurosAnual,idCliente);
        controller.adicionarFinanciamento(financiamento);
        System.out.println("Financiamento Imobiliário adicionado com sucesso!");
    }

    public void adicionarFinanciamentoVeicular(int doc) {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        System.out.print("Digite o valor do financiamento: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite o Prazo do financimento (em meses): ");
        int prazo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Qual é o tipo de veículo a ser financiado? ");
        String tipoVeiculo = scanner.nextLine();
        System.out.print("Digite o ano de fabricação do veículo: ");
        int anoFabricacao = scanner.nextInt();
        System.out.print("Qual é a taxa de juros mensal? ");
        double taxaJurosMensal = scanner.nextDouble();

        FinanciamentoVeicular financiamento = new FinanciamentoVeicular(id, valor, prazo, tipoVeiculo, anoFabricacao, taxaJurosMensal,doc);
        controller.adicionarFinanciamento(financiamento);
        System.out.println("Financiamento Veicular adicionado com sucesso!");
    }

    private void visualizarPrazoTotal() {
        System.out.println(controller.visualizarPrazoTotal());
    }

    private void visualizarParcelasPagas() {
        System.out.print("Digite o ID do financiamento: ");
        int id = scanner.nextInt();
        System.out.print("Digite o número de parcelas pagas do financimento: ");
        int parcelasPagas = scanner.nextInt();

        System.out.println(controller.visualizarParcelasPagas(id, parcelasPagas));
    }

    private void visualizarSaldoAPagar() {
        System.out.print("Digite o ID do financiamento: ");
        int id = scanner.nextInt();
        System.out.print("Digite o número de parcelas pagas: ");
        int parcelasPagas = scanner.nextInt();

        System.out.println(controller.visualizarSaldoAPagar(id, parcelasPagas));
    }
}