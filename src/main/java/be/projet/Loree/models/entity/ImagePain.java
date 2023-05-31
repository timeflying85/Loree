package be.projet.Loree.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagePain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "imagePain")
    private Pain pain;

    @Column(name = "chemin", nullable = false)
    private String cheminImage;


}
