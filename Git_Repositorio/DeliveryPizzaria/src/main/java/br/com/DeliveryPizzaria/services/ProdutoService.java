package br.com.DeliveryPizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.DeliveryPizzaria.domain.Produto;
import br.com.DeliveryPizzaria.repositories.ProdutoRepository;
import br.com.DeliveryPizzaria.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtorepository;

	public Produto buscarPorId(Integer id) {
		Optional<Produto> obj = produtorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("cliente não encontrado! ID: " + id));
	}
	
	public Produto salvar(Produto produto) {
		produto.setId(null);
		return produtorepository.save(produto);
	}
	
	public Produto atualizar(Produto produto) {
		return produtorepository.saveAndFlush(produto);
	}
	
	public void deletar(Integer id) {
		produtorepository.deleteById(id);
	}
	
	public List<Produto> listar(){
		return produtorepository.findAll();
	}
}
