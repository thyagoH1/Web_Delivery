package br.com.DeliveryPizzaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.DeliveryPizzaria.domain.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
