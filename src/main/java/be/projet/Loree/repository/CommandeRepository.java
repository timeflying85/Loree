package be.projet.Loree.repository;

import be.projet.Loree.models.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
