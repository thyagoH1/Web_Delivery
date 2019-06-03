package br.com.DeliveryPizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.DeliveryPizzaria.domain.Cliente;
import br.com.DeliveryPizzaria.repositories.ClienteRepository;
import br.com.DeliveryPizzaria.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienterepository;

	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> obj = clienterepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("cliente não encontrado! ID: " + id));
	}
	
	public Cliente salvar(Cliente cliente) {
		cliente.setId(null);
		return clienterepository.save(cliente);
	}
	
	public Cliente atualizar(Cliente cliente) {
		return clienterepository.saveAndFlush(cliente);
	}
	
	public void deletar(Integer id) {
		clienterepository.deleteById(id);
	}
	
	public List<Cliente> listar(){
		return clienterepository.findAll();
	}
}
