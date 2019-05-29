package br.com.DeliveryPizzaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.DeliveryPizzaria.domain.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer> {

}
