package be.projet.Loree.models.dto;

import be.projet.Loree.models.entity.Evenement;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class EvenementDTO {

    private Long id;
    private String adresse;
    private String description;
    private LocalDateTime beginsAt;
    private LocalDateTime endsAt;

    public static EvenementDTO from(Evenement entity){
        if(entity == null)
            return null;

        return EvenementDTO.builder()
                .id(entity.getId())
                .adresse(entity.getAdresse())
                .description(entity.getDescription())
                .beginsAt(entity.getBeginsAt())
                .endsAt(entity.getEndsAt())
                .build();
    }

}
