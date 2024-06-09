package br.edu.up.Controller;

import br.edu.up.Modelos.Cliente;
import br.edu.up.Modelos.Endereco;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private final List<Cliente> _listaClientes;
    private int qtdJaAdd = 0;
    public ClienteController(){
        _listaClientes = new ArrayList<>();
    }

    public int AddCliente(Cliente cliente){
        qtdJaAdd++;
        cliente.setId(qtdJaAdd);
        _listaClientes.add(cliente);

        return qtdJaAdd;
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
