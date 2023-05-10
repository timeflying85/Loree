package be.projet.Loree.utils;


import be.projet.Loree.models.CommandeStatus;
import be.projet.Loree.models.UtilisateurRole;
import be.projet.Loree.models.entity.*;
import be.projet.Loree.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class DataInit implements InitializingBean {

    private final PainRepository painRepository;

    private final CommandeRepository commandeRepository;

    private final IngredientRepository ingredientRepository;

    private final AllergeneRepository allergeneRepository;

    private final EvenementRepository evenementRepository;

    private final UtilisateurRepository utilisateurRepository;

    public DataInit(PainRepository painRepository, CommandeRepository commandeRepository, IngredientRepository ingredientRepository, AllergeneRepository allergeneRepository, EvenementRepository evenementRepository, UtilisateurRepository utilisateurRepository) {
        this.painRepository = painRepository;
        this.commandeRepository = commandeRepository;
        this.ingredientRepository = ingredientRepository;
        this.allergeneRepository = allergeneRepository;
        this.evenementRepository = evenementRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1);
        utilisateur.setRoles(Collections.singleton(UtilisateurRole.ADMIN));
        utilisateur.setUsername("Tim");
        utilisateur.setPassword("yop");
        utilisateur = utilisateurRepository.save(utilisateur);

        Allergene allergene = new Allergene();
        allergene.setId(1);
        allergene.setNom("Gluten");
        allergene = allergeneRepository.save(allergene);


        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setNom("Levain");
        ingredient.setDescription("Toute la fraicheur");
        ingredient = ingredientRepository.save(ingredient);

        Evenement evenement = new Evenement();
        evenement.setId(1);
        evenement.setAdresse("Leuven");
        evenement.setBeginsAt(LocalDateTime.from(LocalDateTime.of(2023, 8,12, 5,0,0)));
        evenement.setEndsAt(LocalDateTime.from(LocalDateTime.of(2023, 8,12,12,0,0)));
        evenement.setDescription("Marché des artisants");
        evenement = evenementRepository.save(evenement);

        Pain pain = new Pain();
        pain.setId(1);
        pain.setNom("Froment Complet");
        pain.setPrix("500gr - 2,7€ // 700gr - 3,7€");
        pain.setDescription("pavé dense et nourrissant. \n" +
                "Il a une mie brune aux alvéoles irrégulières, un goût acidulé de levain prononcé. ");
        pain = painRepository.save(pain);

        Pain pain1 = new Pain();
        pain1.setId(2);
        pain1.setNom("Epeautre Semi-Complet");
        pain1.setPrix("500gr - 3,2€ // 700gr - 4,4€");
        pain1.setDescription("Subtil et passe-partout. \n" +
                "Il a une mie blanche, dense, régulière et un goût de levain doux : c’est le préféré des boîtes à tartines.");
        pain1 = painRepository.save(pain1);

        Commande commande = new Commande();
        commande.setId(1);
        commande.setStart(LocalDate.from(LocalDate.of(2023,5,14)));
        commande.setStatus(CommandeStatus.PENDING);
//        commande.setUtilisateur();
        commande = commandeRepository.save(commande);


    }
}
