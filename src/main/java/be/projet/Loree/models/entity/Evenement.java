package be.projet.Loree.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evenement_id")
    private long id;

    @Column(name = "location", nullable = false)
    private String adresse;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "BeginsAt", nullable = false)
    private LocalDateTime beginsAt;

    @Column(name = "EndsAt", nullable = false)
    private LocalDateTime endsAt;



}
