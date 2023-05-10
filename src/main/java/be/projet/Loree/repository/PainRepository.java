package be.projet.Loree.repository;

import be.projet.Loree.models.entity.Pain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PainRepository extends JpaRepository<Pain, Long> {
}
