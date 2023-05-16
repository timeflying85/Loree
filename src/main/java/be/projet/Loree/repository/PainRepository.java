package be.projet.Loree.repository;

import be.projet.Loree.models.dto.PainDTO;
import be.projet.Loree.models.entity.Pain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PainRepository extends JpaRepository<Pain, Long> {

    Optional <Pain> findByNom (String nom);

}
