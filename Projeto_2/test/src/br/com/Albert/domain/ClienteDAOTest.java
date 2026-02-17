package br.com.Albert.domain;
import br.com.Albert.dao.IClienteDAO;
import br.com.Albert.exception.TipoChaveNaoEncontradaException;
import dao.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTest() {
    clienteDAO  = new ClienteDAOMock();
    }
    @Before
    public void init()  throws TipoChaveNaoEncontradaException  {
        cliente  = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Albert");
        cliente.setCidade("São Paulo");
        cliente.setEnd("Jardim Campo");
        cliente.setEstado("São Paulo");
        cliente.setNumero(65);
        cliente.setTel(12231234L);
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente()  {
    Cliente clienteConsulta = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsulta);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException {
        clienteDAO.excluir(cliente);
    }

    @Test
    public void alterarCliente()  throws TipoChaveNaoEncontradaException {
        cliente.setNome("Albert");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("Albert", cliente.getNome());
    }

}
