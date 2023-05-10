package be.projet.Loree.controller;


import be.projet.Loree.models.dto.PainDTO;
import be.projet.Loree.models.form.PainInsertForm;
import be.projet.Loree.services.PainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pain")
public class PainController {


    @Autowired
    private final PainService painService;


    public PainController(PainService painService) {
        this.painService = painService;
    }


    @GetMapping("/{id:[0-9]+}")
    public PainDTO getOne(@PathVariable long id){

        return painService.getOne(id);

    }

    @GetMapping("/all")
    public List<PainDTO> getAll() {

        return painService.getAll();

    }

//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<?> create(@RequestBody PainInsertForm painInsertForm) {
//        try {
//
//        }
//    }


}
