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

import br.com.DeliveryPizzaria.domain.Produto;
import br.com.DeliveryPizzaria.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/{produto}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Produto produto = produtoService.buscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Produto produto) {
		produto = produtoService.salvar(produto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(produto.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
		produto.setId(id);
		produto = produtoService.atualizar(produto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer id){
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Produto> lista = produtoService.listar();
		return ResponseEntity.ok().body(lista);
	}
}
