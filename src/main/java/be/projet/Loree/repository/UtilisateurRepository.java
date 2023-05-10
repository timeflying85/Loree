package be.projet.Loree.repository;

import be.projet.Loree.models.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
