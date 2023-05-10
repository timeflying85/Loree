package be.projet.Loree.services;

import be.projet.Loree.models.dto.EvenementDTO;

import java.util.List;

public interface EvenementService {
    EvenementDTO getOne(long id);

    List<EvenementDTO> getAll();
}
