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


    @GetMapping(/*"/{nom:^[a-zA-Z]+$}")*/)
    public PainDTO getOne(@RequestParam String nom){

        return painService.getOne(nom);

    }

    @GetMapping("/all")
    public List<PainDTO> getAll() {

        return painService.getAll();

    }

    @GetMapping({"/{id:[0-9]+}/delete"})
    public void delete(@PathVariable long id){
        painService.delete(id);
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PainInsertForm painInsertForm) {
        try {
            painService.createPain(painInsertForm);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
