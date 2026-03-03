package br.com.albert;

import br.com.albert.domain.Acessorios;
import br.com.albert.domain.dao.AcessoriosDAO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class acessoriosTest {

    private AcessoriosDAO acessoriosDAO;

    public acessoriosTest() {acessoriosDAO = new AcessoriosDAO();}

    @Test
    public void Cadastar() {
        Acessorios acessorio = new Acessorios();
        acessorio.setTurbo("Turbo upgrade");
        acessorio.setFarois("Faróis escurecidos ou LED Matrix");
        acessoriosDAO.cadastrar(acessorio);
        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());
    }
}
