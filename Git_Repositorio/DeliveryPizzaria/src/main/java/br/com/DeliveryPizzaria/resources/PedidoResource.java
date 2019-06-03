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

import br.com.DeliveryPizzaria.domain.Pedido;
import br.com.DeliveryPizzaria.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/{pedido}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorPedido(@PathVariable Integer codigo) {
		Pedido pedido = pedidoService.buscarPorId(codigo);
		return ResponseEntity.ok().body(pedido);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {
		pedido = pedidoService.salvar(pedido);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{codigo}")
				.buildAndExpand(pedido.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer codigo, @RequestBody Pedido pedido) {
		pedido.setCodigo(codigo);
		pedido = pedidoService.atualizar(pedido);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer codigo){
		pedidoService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Pedido> lista = pedidoService.listar();
		return ResponseEntity.ok().body(lista);
	}
}
