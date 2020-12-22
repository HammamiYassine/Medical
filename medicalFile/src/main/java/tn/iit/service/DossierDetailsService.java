package tn.iit.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.DossierDetailsRepository;
import tn.iit.dto.DossierDetailsDTO;
import tn.iit.entity.DossierDetails;
import tn.iit.mapper.DossierDetailsMapper;


@Service
public class DossierDetailsService implements IdossierDetails {
	
    @Autowired
    private DossierDetailsRepository dossierDetailsRepository;
    
    @Override
    public Collection<DossierDetailsDTO> getAllDossierDetails() {
        return DossierDetailsMapper.EntityToDtos(dossierDetailsRepository.findAll());
    }
    
    @Override
    public DossierDetailsDTO findById(int id) {
    	DossierDetails dos = dossierDetailsRepository.findById(id);
    	DossierDetailsDTO resultDTO = DossierDetailsMapper.EntityToDto(dos);
        return resultDTO;
    }
    
    @Override
    public DossierDetailsDTO save(DossierDetailsDTO dosdto) {
    	DossierDetails dos = DossierDetailsMapper.DtoToEntity(dosdto);
        dos =  dossierDetailsRepository.save(dos);
      	DossierDetailsDTO resultDTO = DossierDetailsMapper.EntityToDto(dos);
        return resultDTO;    
    }
    
    @Override
    public void delete(int id) {
    	dossierDetailsRepository.deleteById(id);
    }
    
    
    @Override
	public DossierDetailsDTO update(DossierDetailsDTO dosdto) {
    	DossierDetails dos = DossierDetailsMapper.DtoToEntity(dosdto);
        dos =  dossierDetailsRepository.save(dos);
      	DossierDetailsDTO resultDTO = DossierDetailsMapper.EntityToDto(dos);
        return resultDTO;
	}
}