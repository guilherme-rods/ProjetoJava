package br.edu.up.Controller;
import br.edu.up.DAO.ContaDAO;
import br.edu.up.Modelos.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ContaControler {
    private ContaDAO _dbConta;
    private List<Conta> contas;

    public ContaControler() throws IOException{
        _dbConta = new ContaDAO("contas.csv");
        contas = _dbConta.lerContas();
    }

public String criar (int tipo,int num_conta,double saldo,int cliente) throws IOException{
    Conta conta;
    String msg ="";
    switch (tipo) {
        case 1:
        conta = new ContaPoupanca( num_conta,saldo,cliente) ; 
        msg = "poupança";           
            break ;
        case 2:
        conta = new ContaCorrente( num_conta,saldo,cliente) ;     
        msg = "corrente";
            break ;
        case 3:
        conta = new ContaSalario( num_conta,saldo,cliente) ;  
        msg = "salario";          
            break ;
    
        default:
            return "Tipo de conta invalido";
        }
        this.contas.add(conta);
        _dbConta.salvarContas(contas);
        return "Conta "+ msg +" criada";
    
}
public int buscar(int num_conta) {
 return this.contas.stream().filter(Objects::nonNull).filter(c -> c.getNum_conta() == num_conta).findFirst().get().getNum_conta();
}
public String encerrar(int num_conta)throws IOException{
    String msg= this.contas.stream().filter(Objects::nonNull).filter(c -> c.getNum_conta() == num_conta).findFirst().get().close();
    _dbConta.salvarContas(contas);
    return msg;
}
}
