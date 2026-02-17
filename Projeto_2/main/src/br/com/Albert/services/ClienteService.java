package br.com.Albert.services;
import br.com.Albert.dao.IClienteDAO;
import br.com.Albert.domain.Cliente;

public class ClienteService extends GenericServices<Cliente> implements IClienteServices {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return super.buscar(cpf);
    }

}
