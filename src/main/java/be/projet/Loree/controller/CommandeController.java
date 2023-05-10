package be.projet.Loree.controller;


import be.projet.Loree.models.dto.CommandeDTO;
import be.projet.Loree.services.CommandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/{id:[0-9]+}")
    public CommandeDTO getOne(@PathVariable long id) {

        return commandeService.getOne(id);

    }

    @GetMapping("/all")
    public List<CommandeDTO> getAll() {

        return commandeService.getAll();

    }

}
