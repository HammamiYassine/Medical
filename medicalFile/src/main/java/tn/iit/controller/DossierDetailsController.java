package tn.iit.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.iit.dto.DossierDetailsDTO;
import tn.iit.service.DossierDetailsService;

@RestController
@RequestMapping("/api")
public class DossierDetailsController {
    
    @Autowired
    private DossierDetailsService dossierDetailsService;
    
    @GetMapping(value="/dossierdetails")
    Collection<DossierDetailsDTO> getAll(){
        return dossierDetailsService.getAllDossierDetails();
    }
    

    @GetMapping(value="/dossierdetails/{id}")
    ResponseEntity<DossierDetailsDTO> getById(@PathVariable("id") int id) {
        DossierDetailsDTO dos = dossierDetailsService.findById(id);
        return ResponseEntity.ok().body(dos);
    }
    

    @PostMapping(value="/dossierdetails")
    ResponseEntity<?> createDossierDetails(@RequestBody DossierDetailsDTO indos) {
        DossierDetailsDTO addeddos = dossierDetailsService.save(indos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addeddos.getId_dossierdetails())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping(value="/dossierdetails/{id}")
    ResponseEntity<DossierDetailsDTO> updateDossierDetails(@PathVariable("id") int id,  @RequestBody DossierDetailsDTO indos) {
    	indos.setId_dossierdetails(id);
    	DossierDetailsDTO resultdos = dossierDetailsService.update(indos);
        return ResponseEntity.ok().body(resultdos);    
    }
    
    
    // Delete dossier by ID DELETE /api/dossierdetails/{id}
    @DeleteMapping(value="/dossierdetails/{id}")
    ResponseEntity deleteDossierDetails( @PathVariable("id") int id) {
        dossierDetailsService.delete(id);
        return ResponseEntity.ok().body("Dossier Details with ID : "+id+" deleted with success!");  
    }
}
