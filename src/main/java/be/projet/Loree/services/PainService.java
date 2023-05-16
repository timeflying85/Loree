package be.projet.Loree.services;

import be.projet.Loree.models.dto.PainDTO;
import be.projet.Loree.models.form.PainInsertForm;

import java.util.List;

public interface PainService {

//    PainDTO getOne(long id);

    PainDTO getOne(String nom);

    List<PainDTO> getAll();

    void createPain(PainInsertForm form);

    void delete(long id);
}
