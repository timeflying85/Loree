package be.projet.Loree.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pain_id")
    private long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "prix", nullable = false)
    private String prix;

    @OneToOne( cascade = CascadeType.PERSIST )
    @JoinColumn(name = "pain_image_id")
    private ImagePain imagePain;

    @ManyToMany
    @JoinTable(name = "pain_ingredient",
            joinColumns = @JoinColumn(name = "pain_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients = new ArrayList<>();


}
