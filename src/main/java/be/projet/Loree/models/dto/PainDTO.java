package be.projet.Loree.models.dto;

import be.projet.Loree.models.entity.ImagePain;
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
    private ImagePainDTO imagePain;
    private List<IngredientDTO> ingredients;

    public static PainDTO from(Pain entity){
        if(entity == null)
            return null;

        return PainDTO.builder()
                .id(entity.getId())
                .imagePain(ImagePainDTO.builder().id(entity.getImagePain().getId()).cheminImage(entity.getImagePain().getCheminImage()).build())
                .nom(entity.getNom())
                .prix(entity.getPrix())
                .description(entity.getDescription())
                .ingredients(entity.getIngredients().stream().map(IngredientDTO::from).toList())
                .build();

    }

}
