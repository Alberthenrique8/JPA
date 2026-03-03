package br.com.albert;

import br.com.albert.domain.Marca;
import br.com.albert.domain.dao.MarcaDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class marcaTest {
    private MarcaDAO marcaDAO;

    public marcaTest() {marcaDAO = new MarcaDAO(); }

    @Test
    public void Cadastrar() {
        Marca marca = new Marca();
        marca.setMarca("Porsche");
        marca.setFabricacao("1964");
        marca = marcaDAO.cadastrar(marca);
        assertNotNull(marca);
        assertNotNull(marca.getId());
    }
}
