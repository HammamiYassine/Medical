package tn.iit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.iit.dto.DossierDTO;
import tn.iit.service.DossierService;

@RestController
@RequestMapping("/api/dossiers")
public class DossierController {
    
    @Autowired
    private DossierService dossierService;
    

    @GetMapping(value="")
    ResponseEntity<?> getAll(){
        return new ResponseEntity<List<DossierDTO>> ( dossierService.getAllDossiers(),HttpStatus.OK);
    }
    

    @GetMapping(value="/{id}")
    ResponseEntity<?> getById(@PathVariable("id") int id) {
        DossierDTO dos = dossierService.findById(id);
        return new ResponseEntity<DossierDTO> (dos,HttpStatus.OK);
    }
    

    @PostMapping(value="")
    ResponseEntity<?> createDossier(@RequestBody DossierDTO indos) {
        DossierDTO addeddos = dossierService.save(indos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addeddos.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping(value="/{id}")
    ResponseEntity<DossierDTO> updateDossier(@PathVariable("id") int id,  @RequestBody DossierDTO indos) {
    	indos.setId(id);  
        DossierDTO resultdos = dossierService.update(indos);
        return ResponseEntity.ok().body(resultdos);    
    }
    
    
    @DeleteMapping(value="/{id}")
    ResponseEntity<?> deleteDossier( @PathVariable("id") int id) {
        dossierService.delete(id);
        return new ResponseEntity<String> ("Dossier with ID : "+id+" deleted with success!",HttpStatus.OK);
    }
}
