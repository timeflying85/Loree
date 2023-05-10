package be.projet.Loree.models.form;


import be.projet.Loree.models.entity.Evenement;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EvenementInsertForm {

    private Long id;
    private String adresse;
    private String description;
    private LocalDateTime beginsAt;
    private LocalDateTime endsAt;


    public Evenement toEntity() {

        Evenement evenement = new Evenement();

        evenement.setId(this.getId());
        evenement.setAdresse(this.getAdresse());
        evenement.setDescription(this.getDescription());
        evenement.setBeginsAt(this.getBeginsAt());
        evenement.setEndsAt(this.getEndsAt());

        return evenement;

    }


}
