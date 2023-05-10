package be.projet.Loree.repository;

import be.projet.Loree.models.entity.Allergene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergeneRepository extends JpaRepository<Allergene, Long> {
}
