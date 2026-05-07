package br.com.fiap.beerguide.controller;

import br.com.fiap.beerguide.entity.Beer;
import br.com.fiap.beerguide.service.BeerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
@Tag(name = "Beer", description = "Gestão de Cervejas")
public class BeerController {

    @Autowired
    private BeerService service;

    @GetMapping
    @Operation(summary = "Lista todas as cervejas")
    public List<Beer> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca cerveja por ID")
    public Beer getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/brewery/{id}")
    @Operation(summary = "Lista cervejas por cervejaria")
    public List<Beer> getByBrewery(@PathVariable Long id) {
        // MUDANÇA AQUI: Tirei o "Id" do final para bater com o seu Service
        return service.findByBrewery(id);
    }

    @PostMapping
    @Operation(summary = "Cadastra nova cerveja")
    public Beer create(@RequestBody Beer beer) {
        return service.save(beer);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza cerveja")
    public Beer update(@PathVariable Long id, @RequestBody Beer beer) {
        beer.setId(id);
        return service.save(beer);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove cerveja")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}