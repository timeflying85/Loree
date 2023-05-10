package be.projet.Loree.services.impl;

import be.projet.Loree.models.dto.CommandeDTO;
import be.projet.Loree.repository.CommandeRepository;
import be.projet.Loree.services.CommandeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;


    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public CommandeDTO getOne(long id) {

        return commandeRepository.findById(id)
                .map(CommandeDTO::from)
                .orElseThrow();

    }


    @Override
    public List<CommandeDTO> getAll() {

        return commandeRepository.findAll().stream().map(CommandeDTO::from).toList();

    }


}
