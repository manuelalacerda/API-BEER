package br.com.fiap.beerguide.service;

import br.com.fiap.beerguide.entity.Beer;
import br.com.fiap.beerguide.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerRepository repository;

    @Cacheable("beers")
    public List<Beer> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "beers", key = "#id")
    public Beer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ADICIONE ESTE MÉTODO: É o que o Controller está tentando chamar
    @Cacheable(value = "beers", key = "'brewery-' + #id")
    public List<Beer> findByBrewery(Long id) {
        return repository.findByBreweryId(id);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public Beer save(Beer beer) {
        return repository.save(beer);
    }

    @CacheEvict(value = "beers", allEntries = true)
    public void delete(Long id) {
        repository.deleteById(id);
    }
}