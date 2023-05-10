package be.projet.Loree.services.impl;

import be.projet.Loree.models.dto.PainDTO;
import be.projet.Loree.repository.PainRepository;
import be.projet.Loree.services.PainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PainServiceImpl implements PainService {

    private final PainRepository painRepository;

    public PainServiceImpl(PainRepository painRepository) {
        this.painRepository = painRepository;
    }

    @Override
    public PainDTO getOne(long id) {

        return  painRepository.findById(id)
                .map( PainDTO::from )
                .orElseThrow();

    }

    @Override
    public List<PainDTO> getAll() {

        return painRepository.findAll().stream().map(PainDTO::from).toList();

    }


}
