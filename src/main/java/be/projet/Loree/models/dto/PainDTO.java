package be.projet.Loree.models.dto;

import be.projet.Loree.models.entity.Ingredient;
import be.projet.Loree.models.entity.Pain;
import lombok.Data;
import lombok.Builder;
import java.util.List;

@Data
@Builder
public class PainDTO {

    private Long id;
    private String nom;
    private String description;
    private String prix;
    private List<Ingredient> ingredients;

    public static PainDTO from(Pain entity){
        if(entity == null)
            return null;

        return PainDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prix(entity.getPrix())
                .description(entity.getDescription())
                .ingredients(entity.getIngredients())
                .build();

    }

}
