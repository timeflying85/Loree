package be.projet.Loree.models.dto;

import be.projet.Loree.models.entity.Allergene;
import be.projet.Loree.models.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String nom;
    private String description;
    private List<Allergene> allergenes;

    public static IngredientDTO from(Ingredient entity){
        if (entity == null)
            return null;

        return IngredientDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .description(entity.getDescription())
                .allergenes(entity.getAllergenes())
                .build();

    }

}
