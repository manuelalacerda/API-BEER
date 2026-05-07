package br.com.fiap.beerguide.repository;

import br.com.fiap.beerguide.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findByBreweryId(Long id);
}