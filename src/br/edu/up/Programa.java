package br.edu.up;
import java.io.IOException;

import br.edu.up.Controller.ContaControler;
// import br.edu.up.Views.ClienteView;
import br.edu.up.DAO.*;
import br.edu.up.Modelos.*;

public class Programa {
    public static void main(String[] args) throws IOException {
        ContaDAO conta = new ContaDAO("contas.csv");
        ContaControler cConta = new ContaControler();

        try {           
            cConta.criar(3, conta.lerContas().get(conta.lerContas().size() - 1).getNum_conta()+1, 1000, 10); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
