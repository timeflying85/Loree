package be.projet.Loree.services;

import be.projet.Loree.models.dto.PainDTO;

import java.util.List;

public interface PainService {
    PainDTO getOne(long id);

    List<PainDTO> getAll();
}
