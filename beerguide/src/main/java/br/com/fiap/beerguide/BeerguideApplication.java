package br.com.fiap.beerguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BeerguideApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeerguideApplication.class, args);
	}
}