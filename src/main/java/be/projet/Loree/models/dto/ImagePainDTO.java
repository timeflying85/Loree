package be.projet.Loree.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImagePainDTO {

    private Long id;
    private String cheminImage;


}
