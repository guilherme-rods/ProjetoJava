package br.edu.up.Controller;

import br.edu.up.DAO.ClienteDAO;
import br.edu.up.DAO.ContaDAO;
import br.edu.up.Modelos.Cliente;
import br.edu.up.Modelos.Endereco;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private final ClienteDAO _dbCliente;
    private List<Cliente> _listaClientes;
    private int qtdJaAdd = 0;
    public ClienteController(){
        _dbCliente = new ClienteDAO("clientes.csv");;
        try {
            _listaClientes = _dbCliente.lerClientes();
            qtdJaAdd = _listaClientes.getLast().getId();
        } catch (Exception e) {
            _listaClientes = new ArrayList<>();
        }
    }

    public int AddCliente(Cliente cliente){
        try {
            qtdJaAdd++;
            cliente.setId(qtdJaAdd);
            _dbCliente.adicionar(cliente);
        } catch (Exception e){
            System.out.println("Não foi possível adicionar um cliente");
        }

        return cliente.getId();
    }

    public void AddEndereco(int idCliente, Endereco endereco){
        Get(idCliente).setEndereco(endereco);
    }

    public Cliente Get(String doc){
        for(Cliente cliente : _listaClientes){
            if(cliente.getDocumento().equals(doc)){
                return cliente;
            }
        }

        throw new IllegalArgumentException("Cliente não encontrado");
    }

    public Cliente Get(int id){
        for (Cliente listaCliente : _listaClientes) {
            if (listaCliente.getId() == id) {
                return listaCliente;
            }
        }

        throw new IllegalArgumentException("Cliente não encontrado");
    }

    public void Update(Cliente cliente){
        for(var i = 0; i < _listaClientes.size(); i++){
            if(_listaClientes.get(i).getId() == cliente.getId()){
                _listaClientes.set(i, cliente);
                break;
            }
        }
    }
}
