package br.com.albert;
import br.com.albert.domain.Produto;
import br.com.albert.domain.dao.ProdutoDAO;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class produtoTest {

    private ProdutoDAO produtoDAO;

    public produtoTest() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void Cadastrar() {
        Produto produto = new Produto();
        produto.setNome("Panela");
        produto.setTipoDeProduto("Utensílio Culinário ");
        produto.setValor("RS 40");
        produtoDAO.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

    }
}
