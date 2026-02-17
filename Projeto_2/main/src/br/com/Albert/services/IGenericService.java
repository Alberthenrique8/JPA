package br.com.Albert.services;
import br.com.Albert.domain.Persistente;
import br.com.Albert.exception.TipoChaveNaoEncontradaException;
import java.util.Collection;

public interface IGenericService<T extends Persistente> {
    Boolean salvar(T entity) throws TipoChaveNaoEncontradaException;

    T buscar(Long codigo);

    void excluir(T entity) throws TipoChaveNaoEncontradaException;

    void alterar(T entity) throws TipoChaveNaoEncontradaException;

    Collection<T> buscarTodos();
}
