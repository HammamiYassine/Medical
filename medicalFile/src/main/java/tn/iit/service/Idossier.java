package tn.iit.service;

import java.util.Collection;
import tn.iit.dto.DossierDTO;

public interface Idossier {
	Collection<DossierDTO> getAllDossiers();
	DossierDTO findById(int id);
	DossierDTO save(DossierDTO dos);
    DossierDTO update(DossierDTO dos);
    void delete(int id);
}
