package be.projet.Loree.services.impl;

import be.projet.Loree.models.dto.IngredientDTO;
import be.projet.Loree.repository.IngredientRepository;
import be.projet.Loree.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

        private final IngredientRepository ingredientRepository;


        public IngredientServiceImpl(IngredientRepository ingredientRepository) {
            this.ingredientRepository = ingredientRepository;
        }


        @Override
        public IngredientDTO getOne(long id) {

            return ingredientRepository.findById(id)
                    .map(IngredientDTO::from)
                    .orElseThrow();

        }


        @Override
        public List<IngredientDTO> getAll() {

            return ingredientRepository.findAll().stream().map(IngredientDTO::from).toList();

        }


}
