package be.projet.Loree.models.dto;

import be.projet.Loree.models.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String nom;
    private String description;
    private List<AllergeneDTO> allergenes;

    public Ingredient toEntity() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(this.getId());
        ingredient.setNom(this.getNom());
        ingredient.setDescription(this.getDescription());

        if (this.getAllergenes() != null) {
            ingredient.setAllergenes(this.getAllergenes().stream()
                    .map(AllergeneDTO::toEntity)
                    .collect(Collectors.toList()));
        }

        return ingredient;
    }

    public static IngredientDTO from(Ingredient entity){
        if (entity == null)
            return null;

        return IngredientDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .description(entity.getDescription())
                .allergenes(entity.getAllergenes().stream().map(AllergeneDTO::from).toList())
                .build();

    }

}
