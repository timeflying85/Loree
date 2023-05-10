package be.projet.Loree.models.dto;


import be.projet.Loree.models.entity.Allergene;
import be.projet.Loree.models.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AllergeneDTO {

    private Long id;
    private String nom;
//    private List<Ingredient> ingredients;

    public static AllergeneDTO from(Allergene entity) {
        if (entity == null)
            return null;

        return AllergeneDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .build();


    }

}
