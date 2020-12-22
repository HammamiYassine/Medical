package tn.iit.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class DossierDetailsDTO {
    private int id_dossierdetails;
    private String descriptionart;
    private Integer articleId;
    private int qte;
    private float prix;
    private LocalDateTime date;
    //private Dossier dossier;
    
    
	public int getId_dossierdetails() {
		return id_dossierdetails;
	}
	public void setId_dossierdetails(int id_dossierdetails) {
		this.id_dossierdetails = id_dossierdetails;
	}
	
	public String getDescriptionart() {
		return descriptionart;
	}
	public void setDescriptionart(String descriptionart) {
		this.descriptionart = descriptionart;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/*public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}*/
    
}
