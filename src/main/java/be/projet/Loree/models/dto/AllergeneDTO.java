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
    private String logo;
//    private List<Ingredient> ingredients;

    public Allergene toEntity() {
        Allergene allergene = new Allergene();
        allergene.setId(this.getId());
        allergene.setNom(this.getNom());
        allergene.setLogo(this.getLogo());
        // Autres attributs à convertir

        return allergene;
    }

    public static AllergeneDTO from(Allergene entity) {
        if (entity == null)
            return null;

        String logoFileName = entity.getLogo();
        String logoUrl = "http://localhost:8080/logo/" + logoFileName;

        return AllergeneDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .logo(logoUrl)
                .build();


    }

}
