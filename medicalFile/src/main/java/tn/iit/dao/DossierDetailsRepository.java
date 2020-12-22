package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entity.DossierDetails;


public interface DossierDetailsRepository  extends JpaRepository<DossierDetails, Integer> {
	 DossierDetails findById(int id);
}
