package tn.iit.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.DossierRepository;
import tn.iit.dto.ArticleDTO;
import tn.iit.dto.DossierDTO;
import tn.iit.entity.Dossier;
import tn.iit.exception.IllegalBusinessException;
import tn.iit.mapper.DossierMapper;


@Service
public class DossierService implements Idossier {
    private final Logger log = LoggerFactory.getLogger(DossierService.class);

    @Autowired
    private DossierRepository dossierRepository;
    @Autowired  
    private StoreManagmentServiceClient storeManagmentServiceClient;
    
    @Override
    public List<DossierDTO> getAllDossiers() {
    	return DossierMapper.EntityToDtos(dossierRepository.findAll());
    }
    
    @Override
    public DossierDTO findById(int id) {
    	Dossier dossier  = dossierRepository.findById(id);
    	DossierDTO dossierDTO = DossierMapper.EntityToDto(dossier);
    	
    	List<ArticleDTO> articleDTOS = storeManagmentServiceClient.getAllArticlesDTO();
    	log.debug("Request to get MedicalFile: {}",articleDTOS);

    	dossierDTO.getDossierdetails().forEach(dosdet -> {
    		ArticleDTO articleDTO = articleDTOS.stream()
    				.filter(article -> article.getId().equals(dosdet.getArticleId()))
    				.findFirst()
    				.orElseThrow(()-> new IllegalBusinessException("missing article with id : " + dosdet.getId_dossierdetails()));

    		dosdet.setDescriptionart(articleDTO.getDescription());  	

    	});

        return dossierDTO;
    }
    
    @Override
    public DossierDTO save(DossierDTO dosdto) {
    	Dossier dos = DossierMapper.DtoToEntity(dosdto);
        dos =  dossierRepository.save(dos);
      	DossierDTO resultDTO = DossierMapper.EntityToDto(dos);
        return resultDTO; 
    }
    
    @Override
   	public DossierDTO update(DossierDTO dosdto) {
       	Dossier dos = DossierMapper.DtoToEntity(dosdto);
           dos =  dossierRepository.save(dos);
         	DossierDTO resultDTO = DossierMapper.EntityToDto(dos);
           return resultDTO;
   	}
    
    @Override
    public void delete(int id) {
    	dossierRepository.deleteById(id);
    }
}