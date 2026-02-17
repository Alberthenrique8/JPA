package br.com.Albert.dao;
import br.com.Albert.domain.Persistente;
import generics.GenericDAO;

public class ProdutoDAO<Produto extends Persistente> extends GenericDAO<Produto> implements IProdutoDAO {

    @Override
    public Class<Produto> getTipoClasse() {
        return null;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {

    }
}
