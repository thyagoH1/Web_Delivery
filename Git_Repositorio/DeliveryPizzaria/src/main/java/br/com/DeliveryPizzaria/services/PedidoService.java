package br.com.DeliveryPizzaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import br.com.DeliveryPizzaria.domain.Pedido;
import br.com.DeliveryPizzaria.repositories.PedidoRepository;
import br.com.DeliveryPizzaria.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado! ID: " + id));
	}
	public Pedido salvar(Pedido pedido) {
		pedido.setCodigo(null);
		return pedidoRepository.save(pedido);
	}
	
	public Pedido atualizar(Pedido pedido) {
		return pedidoRepository.saveAndFlush(pedido);
	}
	
	public void deletar(Integer codigo) {
		pedidoRepository.deleteById(codigo);
	}
	
	public List<Pedido> listar(){
		return pedidoRepository.findAll();
	}
}
