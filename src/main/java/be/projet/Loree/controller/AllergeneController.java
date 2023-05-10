package be.projet.Loree.controller;


import be.projet.Loree.models.dto.AllergeneDTO;
import be.projet.Loree.services.AllergeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allergene")
public class AllergeneController {

    @Autowired
    private final AllergeneService allergeneService;

    public AllergeneController(AllergeneService allergeneService) {
        this.allergeneService = allergeneService;
    }

    @GetMapping("/{id:[0-9]+}")
    public AllergeneDTO getOne(@PathVariable long id) {

        return allergeneService.getOne(id);

    }

    @GetMapping("/all")
    public List<AllergeneDTO> getAll() {

        return allergeneService.getAll();

    }


}
