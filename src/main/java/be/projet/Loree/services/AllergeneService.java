package be.projet.Loree.services;

import be.projet.Loree.models.dto.AllergeneDTO;

import java.util.List;

public interface AllergeneService {
    AllergeneDTO getOne(long id);

    List<AllergeneDTO> getAll();
}
