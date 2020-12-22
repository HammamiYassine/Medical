package tn.iit.service;

import java.util.Collection;
import java.util.Optional;

import tn.iit.dto.DossierDetailsDTO;

public interface IdossierDetails {
	Collection<DossierDetailsDTO> getAllDossierDetails();
    DossierDetailsDTO findById(int id);
    DossierDetailsDTO save(DossierDetailsDTO dos);
    DossierDetailsDTO update(DossierDetailsDTO dos);
    void delete(int id);
}
