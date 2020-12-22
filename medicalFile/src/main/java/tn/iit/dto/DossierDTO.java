package tn.iit.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class DossierDTO {
	private int id;
    private String patient;
    private List<DossierDetailsDTO> dossierdetails;
    
	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<DossierDetailsDTO> getDossierdetails() {
		return dossierdetails;
	}

	public void setDossierdetails(List<DossierDetailsDTO> dossierdetails) {
		this.dossierdetails = dossierdetails;
	}
    
	

}