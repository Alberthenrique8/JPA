package br.com.Albert.dao;
import br.com.Albert.domain.Cliente;
import br.com.Albert.exception.TipoChaveNaoEncontradaException;
import generics.IGenericDAO;

public interface IClienteDAO extends IGenericDAO<Cliente> {

    void excluir(Long valor);

    void excluir(Cliente cpf) throws TipoChaveNaoEncontradaException;
}
