package be.projet.Loree.repository;

import be.projet.Loree.models.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
