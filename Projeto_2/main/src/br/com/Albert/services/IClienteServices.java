package br.com.Albert.services;
import br.com.Albert.domain.Cliente;


public interface IClienteServices extends IGenericService<Cliente> {

    Cliente buscarPorCPF(Long cpf);

}
