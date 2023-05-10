package be.projet.Loree.models.form;


import be.projet.Loree.models.entity.Ingredient;
import be.projet.Loree.models.entity.Pain;
import lombok.Data;

import java.util.List;

@Data
public class PainInsertForm {

    private Long id;
    private String nom;
    private String description;
    private String prix;
    private List<Ingredient> ingredients;

    public Pain toEntity() {

        Pain pain = new Pain();

        pain.setId(this.getId());
        pain.setNom(this.getNom());
        pain.setPrix(this.getPrix());
        pain.setDescription(this.getDescription());
        pain.setIngredients(this.getIngredients());

        return pain;

    }

}
