package be.projet.Loree.models.form;


import be.projet.Loree.models.dto.IngredientDTO;
import be.projet.Loree.models.entity.Ingredient;
import be.projet.Loree.models.entity.Pain;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PainInsertForm {


    private String nom;
    private String description;
    private String prix;
    private List<Long> ingredients;

    public Pain toEntity() {

        Pain pain = new Pain();

        pain.setNom(this.getNom());
        pain.setPrix(this.getPrix());
        pain.setDescription(this.getDescription());
//        pain.setIngredients(convertToIngredientList());

        return pain;

    }

//    private List<Ingredient> convertToIngredientList() {
//        if (this.getIngredients() == null) {
//            return Collections.emptyList();
//        }
//
//        return this.getIngredients().stream()
//                .map(IngredientDTO::toEntity)
//                .collect(Collectors.toList());
//    }

}
