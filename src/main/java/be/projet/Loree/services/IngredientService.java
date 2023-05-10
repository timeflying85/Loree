package be.projet.Loree.services;

import be.projet.Loree.models.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {
    IngredientDTO getOne(long id);

    List<IngredientDTO> getAll();
}
