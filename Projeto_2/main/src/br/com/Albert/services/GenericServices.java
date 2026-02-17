package br.com.Albert.services;

import br.com.Albert.dao.IClienteDAO;
import br.com.Albert.domain.Persistente;
import br.com.Albert.exception.TipoChaveNaoEncontradaException;
import generics.IGenericDAO;

import java.util.Collection;

public abstract class GenericServices<T extends Persistente> implements IGenericService<T> {

    protected IGenericDAO<T> dao;

    public GenericServices(IGenericDAO<T>dao){
        this.dao =  dao;
    }

      @Override
    public Boolean salvar(T entity) throws TipoChaveNaoEncontradaException {
        return dao.cadastrar(entity);
    }

    @Override
    public T buscar(Long codigo){
        return dao.consultar(codigo);
    }

    @Override
    public void excluir(T entity) throws TipoChaveNaoEncontradaException {
        dao.excluir(entity);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException{
        dao.alterar(entity);
    }

    @Override
    public Collection<T> buscarTodos() {
        return dao.buscarTodos();
    }
}
