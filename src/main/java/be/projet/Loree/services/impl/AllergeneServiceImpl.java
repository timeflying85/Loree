package be.projet.Loree.services.impl;

import be.projet.Loree.models.dto.AllergeneDTO;
import be.projet.Loree.repository.AllergeneRepository;
import be.projet.Loree.services.AllergeneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergeneServiceImpl implements AllergeneService {

    private final AllergeneRepository allergeneRepository;


    public AllergeneServiceImpl(AllergeneRepository allergeneRepository) {
        this.allergeneRepository = allergeneRepository;
    }

    @Override
    public AllergeneDTO getOne(long id) {

        return allergeneRepository.findById(id)
                .map(AllergeneDTO::from)
                .orElseThrow();

    }

    @Override
    public List<AllergeneDTO> getAll() {

        return allergeneRepository.findAll()
                .stream()
                .map(AllergeneDTO::from)
                .toList();

    }


}
