package br.edu.up;

import br.edu.up.Views.MenuView;
import java.io.IOException;

public class Programa {
    public static void main(String[] args) {
        try {
            MenuView menuView = new MenuView();
            menuView.exibirMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
