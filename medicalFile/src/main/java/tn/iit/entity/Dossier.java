package tn.iit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "dossier")
@EntityListeners(AuditingEntityListener.class)
public class Dossier implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dossier;
    private String patient;
    
    @JsonIgnore
    @OneToMany(mappedBy = "dossier", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    public List<DossierDetails> dossierdetails;
    
	public int getId_dossier() {
		return id_dossier;
	}
	public void setId_dossier(int id_dossier) {
		this.id_dossier = id_dossier;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	
	
	public List<DossierDetails> getDossierdetails() {
		return dossierdetails;
	}
	public void setDossierdetails(List<DossierDetails> dossierdetails) {
		this.dossierdetails = dossierdetails;
	}
	public Dossier() {
		super();
	}
    
	
    
    
}