package br.com.DeliveryPizzaria.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.DeliveryPizzaria.domain.Cliente;
import br.com.DeliveryPizzaria.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {
		cliente = clienteService.salvar(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		cliente = clienteService.atualizar(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Cliente> lista = clienteService.listar();
		return ResponseEntity.ok().body(lista);
	}
}
