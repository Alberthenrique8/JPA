package br.com.Albert.dao;
import br.com.Albert.domain.Cliente;
import generics.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    @Override
    public Class<Cliente> getTipoClasse() {
        return null;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    @Override
    public void excluir(Long valor) {

    }
}
