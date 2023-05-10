package be.projet.Loree.services.impl;

import be.projet.Loree.models.dto.EvenementDTO;
import be.projet.Loree.repository.EvenementRepository;
import be.projet.Loree.services.EvenementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementServiceImpl implements EvenementService {

    private final EvenementRepository evenementRepository;


    public EvenementServiceImpl(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }


    @Override
    public EvenementDTO getOne(long id) {

        return evenementRepository.findById(id)
                                  .map(EvenementDTO::from)
                                  .orElseThrow();

    }

    @Override
    public List<EvenementDTO> getAll() {

        return evenementRepository.findAll().stream().map(EvenementDTO::from).toList();

    }


}
