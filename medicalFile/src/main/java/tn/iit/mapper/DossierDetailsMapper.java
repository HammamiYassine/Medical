package tn.iit.mapper;

import java.util.ArrayList;
import java.util.Collection;

import tn.iit.dto.DossierDetailsDTO;
import tn.iit.entity.DossierDetails;



public class DossierDetailsMapper {
	public static  DossierDetails DtoToEntity( DossierDetailsDTO dos) {
		 DossierDetails dossier = new  DossierDetails();
		 dossier.setArticleId(dos.getArticleId());
		 dossier.setId_dossierdetails(dos.getId_dossierdetails());
		 dossier.setQte(dos.getQte());
		 dossier.setPrix(dos.getPrix());
		 dossier.setDate(dos.getDate());
		 //dossier.setDossier(dos.getDossier());
       return dossier ;
	}
	
	   public static DossierDetailsDTO EntityToDto(DossierDetails dos) {
		   DossierDetailsDTO dossierDetailsDTO = new DossierDetailsDTO();
		   dossierDetailsDTO.setId_dossierdetails(dos.getId_dossierdetails());
		   dossierDetailsDTO.setArticleId(dos.getArticleId());
		   dossierDetailsDTO.setQte(dos.getQte());
		   dossierDetailsDTO.setPrix(dos.getPrix());
		   dossierDetailsDTO.setDate(dos.getDate());
		   //dossierDetailsDTO.setDossier(dos.getDossier());
          return dossierDetailsDTO;                            
      }
	   
	   public static Collection<DossierDetailsDTO> EntityToDtos(Collection<DossierDetails> doss) {
		   Collection<DossierDetailsDTO> dosdets = new ArrayList<>();
		   doss.forEach(dos -> {
			   dosdets.add(EntityToDto(dos));
		   });
           return dosdets;                            
       }
}
