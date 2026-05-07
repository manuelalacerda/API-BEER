package br.com.fiap.beerguide.repository;

import br.com.fiap.beerguide.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}