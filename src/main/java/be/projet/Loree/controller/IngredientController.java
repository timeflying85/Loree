package be.projet.Loree.controller;


import be.projet.Loree.models.dto.IngredientDTO;
import be.projet.Loree.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping("/{id:[0-9]+}")
    public IngredientDTO getOne(@PathVariable long id) {

        return ingredientService.getOne(id);

    }


    @GetMapping("/all")
    public List<IngredientDTO> getAll() {

        return ingredientService.getAll();

    }


}
