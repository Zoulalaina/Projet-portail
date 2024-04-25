package Zoul.lalaina.BackEnd.controller;

import Zoul.lalaina.BackEnd.execp.ResourceNotFound;
import Zoul.lalaina.BackEnd.model.Ecole;
import Zoul.lalaina.BackEnd.repository.EcoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/ecole")
public class EcoleController {
    @Autowired
    private EcoleRepository ecoleRepository;
    @GetMapping
    public List<Ecole> getAll(){
        return ecoleRepository.findAll();
    }
    @PostMapping
    public Ecole createEcole(@RequestBody Ecole ecole){
        return ecoleRepository.save(ecole);
    }
    @GetMapping("{id}")
    public ResponseEntity<Ecole> getById(@PathVariable int id){
        Ecole ecole = ecoleRepository.findById(id).orElseThrow(()->new ResourceNotFound("Ecole not found with id: "+id));
        return ResponseEntity.ok(ecole);
    }
    @PutMapping("{id}")
    public ResponseEntity<Ecole> update(@PathVariable int id,@RequestBody Ecole ecoleDetaits){
        Ecole ecoleUpdated = ecoleRepository.findById(id).orElseThrow(()->new ResourceNotFound("Ecolo not found with id : "+id));
        ecoleUpdated.setNom(ecoleDetaits.getNom());
        ecoleUpdated.setUniversite(ecoleDetaits.getUniversite());

        ecoleRepository.save(ecoleUpdated);
        return ResponseEntity.ok(ecoleUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Ecole> delete(@PathVariable int id){
        Ecole ecole = ecoleRepository.findById(id).orElseThrow(()->new ResourceNotFound("Ecole not found with id : "+id));
        ecoleRepository.delete(ecole);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
