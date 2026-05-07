package br.com.fiap.beerguide.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double alcoholContent;
    private String harmonization;

    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;
}