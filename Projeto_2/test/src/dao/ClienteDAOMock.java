package dao;

import br.com.Albert.exception.TipoChaveNaoEncontradaException;
import br.com.Albert.dao.IClienteDAO;
import br.com.Albert.domain.Cliente;
import java.util.Collection;


public class ClienteDAOMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Cliente valor) {

    }


    @Override
    public void excluir(Long valor) {
        }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }


}
