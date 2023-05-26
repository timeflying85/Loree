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
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final PainRepository painRepository;

    private final CommandeRepository commandeRepository;

    private final IngredientRepository ingredientRepository;

    private final AllergeneRepository allergeneRepository;

    private final EvenementRepository evenementRepository;

    private final UtilisateurRepository utilisateurRepository;
    private final ImagePainRepository imagePainRepository;

    public DataInit(PainRepository painRepository, CommandeRepository commandeRepository, IngredientRepository ingredientRepository, AllergeneRepository allergeneRepository, EvenementRepository evenementRepository, UtilisateurRepository utilisateurRepository, ImagePainRepository imagePainRepository) {
        this.painRepository = painRepository;
        this.commandeRepository = commandeRepository;
        this.ingredientRepository = ingredientRepository;
        this.allergeneRepository = allergeneRepository;
        this.evenementRepository = evenementRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.imagePainRepository = imagePainRepository;
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
        allergene.setNom("Blé");
        allergene.setLogo("du-ble.png");
        allergene = allergeneRepository.save(allergene);

        Allergene allergene1 = new Allergene();
        allergene1.setId(2);
        allergene1.setNom("Lait");
        allergene1.setLogo("carton-de-lait.png");
        allergene1 = allergeneRepository.save(allergene1);

        List<Allergene> ListAllergenes = List.of(allergene);
        List<Allergene> ListAllergenes1 = List.of(allergene1);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setNom("Levain");
        ingredient.setDescription("Toute la fraicheur");
        ingredient = ingredientRepository.save(ingredient);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(2);
        ingredient1.setNom("Blé");
        ingredient1.setDescription("Frais et Bio");
        ingredient1.setAllergenes(ListAllergenes);
        ingredient1 = ingredientRepository.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(3);
        ingredient2.setNom("Lait de vache");
        ingredient2.setDescription("Crémeux et frais");
        ingredient2.setAllergenes(ListAllergenes1);
        ingredient2 = ingredientRepository.save(ingredient2);

        List<Ingredient> ListIngredient = List.of(ingredient, ingredient1);
        List<Ingredient> ListIngredient1 = List.of(ingredient, ingredient1, ingredient2);

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
        pain.setDescription("Pavé dense et nourrissant. \n" +
                "Il a une mie brune aux alvéoles irrégulières, un goût acidulé de levain prononcé. ");
        pain.setIngredients(ListIngredient);

        ImagePain image2 = new ImagePain();
        image2.setCheminImage("fromentComplet.jpg");
        image2 = imagePainRepository.save(image2);

        pain.setImagePain(image2);
        pain = painRepository.save(pain);

        Pain pain1 = new Pain();
        pain1.setId(2);
        pain1.setNom("Epeautre Semi-Complet (65%)");
        pain1.setPrix("500gr - 3,2€ // 700gr - 4,4€");
        pain1.setDescription("Subtil et passe-partout. \n" +
                "Il a une mie blanche, dense, régulière et un goût de levain doux : c’est le préféré des boîtes à tartines.");
        pain1.setIngredients(ListIngredient1);

        ImagePain image = new ImagePain();
        image.setCheminImage("epeautreSemiComplet.jpg");
        image = imagePainRepository.save(image);

        pain1.setImagePain(image);
        pain1 = painRepository.save(pain1);


        Pain pain2 = new Pain();
        pain2.setId(3);
        pain2.setNom("Froment Aux Graines");
        pain2.setPrix("500gr-3,1€ // 700gr-4,2€");
        pain2.setDescription("Gourmandise pleine de surprises.\n" +
                " Il a une mie grise aux alvéoles régulières, un goût de levain masqué derrière celui prononcé des graines.");
        pain2.setIngredients(ListIngredient1);


        ImagePain image1 = new ImagePain();
        image1.setCheminImage("fromentAuxGraines.jpg");
        image1 = imagePainRepository.save(image1);

        pain2.setImagePain(image1);
        pain2 = painRepository.save(pain2);



        Pain pain3 = new Pain();
        pain3.setId(4);
        pain3.setNom("Petit Epeautre (Engrain 100%)");
        pain3.setPrix("500gr-4,2€");
        pain3.setDescription("Denrée précieuse pour ceux qui ont une légère intolérance au gluten (il en contient mais d'une qualité différente). \n" +
                "Il a une mie serrée dorée et humide, un goût fleuri et légèrement épicé surprenant.");
        pain3.setIngredients(ListIngredient);

        ImagePain image3 = new ImagePain();
        image3.setCheminImage("petitEpeautre.jpg");
        image3 = imagePainRepository.save(image3);

        pain3.setImagePain(image3);
        pain3 = painRepository.save(pain3);

        Pain pain4 = new Pain();
        pain4.setId(5);
        pain4.setNom("Froment Semi-complet (65%)");
        pain4.setPrix(" 500gr-3€ // 700gr-4€");
        pain4.setDescription("Classique pour toutes occasions. \n" +
                "Il a une mie grise aux alvéoles irrégulières, au goût tendre et au levain doux.");
        pain4.setIngredients(ListIngredient);

        ImagePain image4 = new ImagePain();
        image4.setCheminImage("fromentSemiComplet.jpg");
        image4 = imagePainRepository.save(image4);

        pain4.setImagePain(image4);
        pain4 = painRepository.save(pain4);

        Commande commande = new Commande();
        commande.setId(1);
        commande.setStart(LocalDate.from(LocalDate.of(2023,5,14)));
        commande.setStatus(CommandeStatus.PENDING);
//        commande.setUtilisateur();
        commande = commandeRepository.save(commande);


    }
}
