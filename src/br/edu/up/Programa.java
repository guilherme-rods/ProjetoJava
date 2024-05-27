package br.edu.up;

import br.edu.up.Views.ClienteView;

public class Programa {
    public static void main(String[] args) {
        var view = new ClienteView();

        view.AddCliente();
    }

    public static void ShowMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1) Adicionar usuário");

        System.out.println();
    }
}
