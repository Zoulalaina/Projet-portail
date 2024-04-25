package Zoul.lalaina.BackEnd.controller;

import Zoul.lalaina.BackEnd.execp.ResourceNotFound;
import Zoul.lalaina.BackEnd.model.Ecole;
import Zoul.lalaina.BackEnd.model.Etablissement;
import Zoul.lalaina.BackEnd.model.Faculte;
import Zoul.lalaina.BackEnd.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/etablissement")
public class EtablissementController {
    @Autowired
    private EtablissementRepository etablissementRepository;
    @GetMapping
    public List<Etablissement> getAll(){
        return etablissementRepository.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Etablissement> getById(@PathVariable int id){
        Etablissement etablissement = etablissementRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Etablissement not found with id : "+id));
        return ResponseEntity.ok(etablissement);
    }
}
