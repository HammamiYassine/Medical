package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entity.Dossier;
import tn.iit.entity.DossierDetails;


public interface DossierRepository extends JpaRepository<Dossier, Integer> {
	 Dossier findById(int id);

}
