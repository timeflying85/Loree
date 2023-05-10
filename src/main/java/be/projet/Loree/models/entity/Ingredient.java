package be.projet.Loree.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "ingredients")
    private List<Pain> pains;

    @ManyToMany
    @JoinTable(name = "ingredient_allergene",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergene_id"))
    private List<Allergene> allergenes = new ArrayList<>();



}
