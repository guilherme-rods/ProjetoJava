package br.edu.up.Controller;

import br.edu.up.Modelos.Cliente;
import br.edu.up.Modelos.Endereco;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> _listaClientes;
    public ClienteController(){
        _listaClientes = new ArrayList<>();
    }

    public int AddCliente(Cliente cliente){
        _listaClientes.add(cliente);
        return _listaClientes.size();
    }

    public void AddEndereco(int clienteIndex, Endereco endereco){
        _listaClientes.get(clienteIndex).setEndereco(endereco);
    }

    public Cliente Get(String doc){
        for(Cliente cliente : _listaClientes){
            if(cliente.getDocumento().equals(doc)){
                return cliente;
            }
        }

        throw new IllegalArgumentException("Cliente não encontrado");
    }

    public void Update(Cliente cliente){
        for(Cliente c : _listaClientes){
            if(c.getDocumento().equals(cliente.getDocumento())){
                c = cliente;
                break;
            }
        }
    }
}
