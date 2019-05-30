package br.com.DeliveryPizzaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.DeliveryPizzaria.domain.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {

}
