package be.projet.Loree.models.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Allergene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allergene_id")
    private long id;

    @Column(name = "nom",nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "allergenes")
    private List<Ingredient> ingredients = new ArrayList<>();


}
