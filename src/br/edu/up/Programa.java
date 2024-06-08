package br.edu.up;
import java.io.IOException;
// import br.edu.up.Views.ClienteView;
import br.edu.up.DAO.*;
import br.edu.up.Modelos.*;

public class Programa {
    public static void main(String[] args) {
        String caminhoArquivo = "teste.csv";
        CsvDAO dao = new CsvDAO(caminhoArquivo);
        ContaDAO conta = new ContaDAO("contas.csv");

        try {            
            System.out.println("Registros atuais:");
            for (Registro r : dao.lerRegistros()) {
                System.out.println(r);
            }
            
            Registro novoRegistro = new Registro(4, "Daniel", 28);
            dao.adicionarRegistro(novoRegistro,"id;nome;idade");
            ContaCorrente contaC = new ContaCorrente(0, 0, 0);
            contaC = new ContaCorrente(conta.lerContas().get(conta.lerContas().size() - 1).getNum_conta()+1, 0, 1);

            conta.adicionarConta(contaC);
            
            Registro registroAtualizado = new Registro(2, "Bruno Silva", 31);
            dao.atualizarRegistro(registroAtualizado,"id;nome;idade");
            
            dao.deletarRegistro(3,"id;nome;idade");
            
            System.out.println("Registros após alterações:");
            for (Registro r : dao.lerRegistros()) {
                System.out.println(r);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
