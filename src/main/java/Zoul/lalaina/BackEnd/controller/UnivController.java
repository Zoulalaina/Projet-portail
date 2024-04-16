package Zoul.lalaina.BackEnd.controller;

import Zoul.lalaina.BackEnd.execp.ResourceNotFound;
import Zoul.lalaina.BackEnd.model.Universite;
import Zoul.lalaina.BackEnd.repository.UnivRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/university")
public class UnivController {

    @Autowired
    private UnivRepository univRepository;
    @GetMapping
    public List<Universite> getAllUniv(){
        return univRepository.findAll();
    }
    //Create
    @PostMapping
    public String createUniv(@RequestParam("file") MultipartFile file, @RequestParam("nomUniversite") String nomUniversite, @RequestParam("siegeUniversite") String siegeUniversite) throws IOException {

        Universite universite = new Universite();
        universite.setNomUniversite(nomUniversite);
        universite.setSiegeUniversite(siegeUniversite);
        universite.setImage(file.getBytes());
        univRepository.save(universite);
        return "BD saved";

    }
    //get by id
    @GetMapping("{id}")
    public ResponseEntity<Universite> getUnivById(@PathVariable int id){
        Universite universite = univRepository.findById(id).orElseThrow(()->new ResourceNotFound("Universite not exist with id :"+id));
        return ResponseEntity.ok(universite);
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity<Universite> updateUniv(@PathVariable int id,@RequestParam("file") MultipartFile file, @RequestParam("nomUniversite") String nomUniversite, @RequestParam("siegeUniversite") String siegeUniversite) throws IOException {
        Universite universiteUpdated = univRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Universite not exist with id :"+id));
        universiteUpdated.setNomUniversite(nomUniversite);
        universiteUpdated.setSiegeUniversite(siegeUniversite);
        universiteUpdated.setImage(file.getBytes());
        univRepository.save(universiteUpdated);
        return ResponseEntity.ok(universiteUpdated);
    }

    //Delete

    @DeleteMapping("{id}")
    public ResponseEntity<Universite> deleteUniv(@PathVariable int id){
        Universite universite = univRepository.findById(id).orElseThrow(()->new ResourceNotFound("Universite not exist with id :"+id));
        univRepository.delete(universite);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
