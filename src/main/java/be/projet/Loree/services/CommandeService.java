package be.projet.Loree.services;

import be.projet.Loree.models.dto.CommandeDTO;

import java.util.List;

public interface CommandeService {
    CommandeDTO getOne(long id);

    List<CommandeDTO> getAll();
}
