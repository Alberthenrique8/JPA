package br.com.Albert.domain;
import br.com.Albert.dao.IClienteDAO;
import br.com.Albert.exception.TipoChaveNaoEncontradaException;
import br.com.Albert.services.ClienteService;
import br.com.Albert.services.IClienteServices;
import dao.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteServices clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
       IClienteDAO dao = new ClienteDAOMock();
       clienteService = new ClienteService(dao);
  }

  @Before
  public void init(){
      cliente  = new Cliente();
      cliente.setCpf(12312312312L);
      cliente.setNome("Albert");
      cliente.setCidade("São Paulo");
      cliente.setEnd("Jardim Campo");
      cliente.setEstado("São Paulo");
      cliente.setNumero(65);
      cliente.setTel(12231234L);
  }

    @Test
    public void pesquisarCliente(){
    Cliente clienteConsultado = clienteService.buscarPorCPF((Long) cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
           boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException {
        clienteService.excluir(cliente);
    }

    @Test
    public void alterarCliente()  throws TipoChaveNaoEncontradaException  {
        cliente.setNome("Albert");
        clienteService.alterar(cliente);
        Assert.assertEquals("Albert", cliente.getNome());
    }

}
