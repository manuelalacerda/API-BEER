package br.com.fiap.beerguide.controller;

import br.com.fiap.beerguide.entity.Brewery;
import br.com.fiap.beerguide.service.BreweryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breweries")
@Tag(name = "Brewery", description = "Gestão de Cervejarias")
public class BreweryController {

    @Autowired
    private BreweryService service;

    @GetMapping
    @Operation(summary = "Lista todas as cervejarias")
    public List<Brewery> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca cervejaria por ID")
    public Brewery getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cadastra nova cervejaria")
    public Brewery create(@RequestBody Brewery brewery) {
        return service.save(brewery);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza cervejaria")
    public Brewery update(@PathVariable Long id, @RequestBody Brewery brewery) {
        brewery.setId(id);
        return service.save(brewery);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cervejaria")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}