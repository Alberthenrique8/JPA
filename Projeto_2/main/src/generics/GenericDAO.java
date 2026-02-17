package generics;

import br.com.Albert.anotacoes.TipoChave;
import br.com.Albert.domain.Persistente;
import br.com.Albert.exception.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    private SingletonMap singletonMap;

    public abstract Class<T> getTipoClasse();

    public abstract void atualiarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    /**
     * Garante que sempre exista um mapa interno para a classe
     */
    private Map<Long, T> getMapaInterno() {
        Map<Class, Map<Long, ?>> mapaPrincipal = singletonMap.getMap();

        if (!mapaPrincipal.containsKey(getTipoClasse())) {
            mapaPrincipal.put(getTipoClasse(), new HashMap<>());
        }

        return (Map<Long, T>) mapaPrincipal.get(getTipoClasse());
    }

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {

                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();

                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    return (Long) method.invoke(entity);

                } catch (NoSuchMethodException |
                         IllegalAccessException |
                         InvocationTargetException e) {

                    throw new TipoChaveNaoEncontradaException(
                            "Chave principal do objeto "
                                    + entity.getClass()
                                    + " não encontrada", e);
                }
            }
        }

        throw new TipoChaveNaoEncontradaException(
                "Chave principal do objeto "
                        + entity.getClass()
                        + " não encontrada");
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {

        Map<Long, T> mapaInterno = getMapaInterno();

        Long chave = getChave(entity);

        if (mapaInterno.containsKey(chave)) {
            return false;
        }

        mapaInterno.put(chave, entity);
        return true;
    }

    @Override
    public void excluir(T entity) throws TipoChaveNaoEncontradaException {

        Map<Long, T> mapaInterno = getMapaInterno();
        Long chave = getChave(entity);

        mapaInterno.remove(chave);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {

        Map<Long, T> mapaInterno = getMapaInterno();
        Long chave = getChave(entity);

        T objetoCadastrado = mapaInterno.get(chave);

        if (objetoCadastrado != null) {
            atualiarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(Long valor) {

        Map<Long, T> mapaInterno = getMapaInterno();
        return mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {

        Map<Long, T> mapaInterno = getMapaInterno();
        return mapaInterno.values();
    }
}
