package br.com.fiap.beerguide.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
}