package br.com.fiap.beerguide.service;

import br.com.fiap.beerguide.entity.Brewery;
import br.com.fiap.beerguide.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreweryService {

    @Autowired
    private BreweryRepository repository;

    @Cacheable("breweries") // [cite: 46, 63]
    public List<Brewery> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "breweries", key = "#id") // [cite: 46, 63]
    public Brewery findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @CacheEvict(value = "breweries", allEntries = true) // [cite: 47, 63]
    public Brewery save(Brewery brewery) {
        return repository.save(brewery);
    }

    @CacheEvict(value = "breweries", allEntries = true) // [cite: 47, 63]
    public void delete(Long id) {
        repository.deleteById(id);
    }
}