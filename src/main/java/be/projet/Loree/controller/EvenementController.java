package be.projet.Loree.controller;


import be.projet.Loree.models.dto.EvenementDTO;
import be.projet.Loree.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EvenementController {


    @Autowired
    private final EvenementService evenementService;


    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping("/{id:[0-9]+}")
    public EvenementDTO getOne(@PathVariable long id) {

        return evenementService.getOne(id);

    }

    @GetMapping("/all")
    public List<EvenementDTO> getAll() {

        return evenementService.getAll();

    }


}
