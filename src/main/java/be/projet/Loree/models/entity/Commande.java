package be.projet.Loree.models.entity;


import be.projet.Loree.models.CommandeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id")
    private long id;

    @Column(name = "start", nullable = false)
    private LocalDate start;

    @Enumerated(EnumType.STRING)
    @Column(name = "commande_status", nullable = false)
    private CommandeStatus status;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
