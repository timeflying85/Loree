package be.projet.Loree.models.form;


import be.projet.Loree.models.entity.Allergene;
import be.projet.Loree.models.entity.Ingredient;
import be.projet.Loree.models.entity.Pain;
import lombok.Data;

import java.util.List;

@Data
public class IngredientInsertForm {

    private Long id;
    private String nom;
    private String description;
    private List<Pain> pains;
    private List<Allergene> allergenes;

    public Ingredient toEntity() {

        Ingredient ingredient = new Ingredient();

        ingredient.setId(this.getId());
        ingredient.setNom(this.getNom());
        ingredient.setDescription(this.getDescription());

        return ingredient;

    }



}
