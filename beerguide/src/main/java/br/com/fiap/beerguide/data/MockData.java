package br.com.fiap.beerguide.data;

import br.com.fiap.beerguide.entity.Beer;
import br.com.fiap.beerguide.entity.Brewery;
import br.com.fiap.beerguide.repository.BeerRepository;
import br.com.fiap.beerguide.repository.BreweryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockData {

    @Bean
    CommandLineRunner initDatabase(BreweryRepository bRepo, BeerRepository beerRepo) {
        return args -> {
            // Criando 3 Cervejarias [cite: 44]
            Brewery sAlta = new Brewery(); sAlta.setName("Serra Alta"); sAlta.setCountry("Brasil");
            Brewery rNegro = new Brewery(); rNegro.setName("Rio Negro"); rNegro.setCountry("Brasil");
            Brewery vVerde = new Brewery(); vVerde.setName("Vale Verde"); vVerde.setCountry("Brasil");

            bRepo.save(sAlta); bRepo.save(rNegro); bRepo.save(vVerde);

            // Criando 6 Cervejas [cite: 44]
            beerRepo.save(createBeer("Primavera IPA", "IPA forte", 6.5, "Frango, queijos", sAlta)); // [cite: 10, 12, 14]
            beerRepo.save(createBeer("Serra Inverno", "IPA escura", 7.0, "Carnes", sAlta));
            beerRepo.save(createBeer("Noite Stout", "Stout densa", 7.2, "Chocolate, carne", rNegro)); // [cite: 16, 18, 20]
            beerRepo.save(createBeer("Rio Amber", "Amber Ale", 5.5, "Burgers", rNegro));
            beerRepo.save(createBeer("Lager do Sol", "Lager leve", 4.8, "Petiscos, saladas", vVerde)); // [cite: 22, 24, 26]
            beerRepo.save(createBeer("Vale Gold", "Pilsen", 4.5, "Peixes", vVerde));
        };
    }

    private Beer createBeer(String name, String desc, Double alc, String harm, Brewery b) {
        Beer beer = new Beer();
        beer.setName(name);
        beer.setDescription(desc);
        beer.setAlcoholContent(alc);
        beer.setHarmonization(harm);
        beer.setBrewery(b);
        return beer;
    }
}