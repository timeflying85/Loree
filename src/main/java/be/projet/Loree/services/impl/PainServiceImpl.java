package be.projet.Loree.services.impl;

import be.projet.Loree.models.dto.PainDTO;
import be.projet.Loree.models.entity.Ingredient;
import be.projet.Loree.models.entity.Pain;
import be.projet.Loree.models.form.PainInsertForm;
import be.projet.Loree.repository.IngredientRepository;
import be.projet.Loree.repository.PainRepository;
import be.projet.Loree.services.PainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PainServiceImpl implements PainService {

    private final PainRepository painRepository;
    private final IngredientRepository ingredientRepository;

    public PainServiceImpl(PainRepository painRepository, IngredientRepository ingredientRepository) {
        this.painRepository = painRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PainDTO getOne(String nom) {

        return  painRepository.findByNom(nom)
                .map( PainDTO::from )
                .orElseThrow(()-> new NoSuchElementException("Pain not found"));

    }

    @Override
    public List<PainDTO> getAll() {

        return painRepository.findAll().stream().map(PainDTO::from).toList();

    }

    @Override
    public void createPain(PainInsertForm form) {

        Pain pain = form.toEntity();

        List<Ingredient> ings= ingredientRepository.findAllById(form.getIngredients());
        pain.setIngredients(ings);

        painRepository.save( pain );

    }


    @Override
    public void delete(long id) {

        painRepository.deleteById(id);

    }


}
