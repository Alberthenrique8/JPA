package br.com.albert;

import br.com.albert.domain.Carro;
import br.com.albert.domain.Marca;
import br.com.albert.domain.dao.CarroDAO;
import br.com.albert.domain.dao.MarcaDAO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class carroTest {

    private CarroDAO carroDAO;

    private MarcaDAO marcaDAO;

    public carroTest() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
    }

    @Test
    public void Cadastrar() {
        Marca marca = criarMarca("Porsche");

        Carro carro = new Carro();
        carro.setModelo("911 Carrera S");
        carro.setCor("Prata");
        carro.setMarca(marca);
        carroDAO.cadastrar(carro);


        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    private Marca  criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setMarca(codigo);
        marca.setFabricacao("1964");
        return marcaDAO.cadastrar(marca);
    }
}
