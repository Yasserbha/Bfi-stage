package tn.bfi.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table(name="StageDemande")
public class StageDemande implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	private String nom ;
	
	@Column(name ="phoneNumber")
	private int numero;
	
	private String prenom ;
	
	private String email ;
	
	private String etabilssement ;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date datefin;
	
	@Enumerated(EnumType.STRING)
	private Niveau diplome;
	
	@Enumerated(EnumType.STRING)
	private Classe classe ;
	
	@Enumerated(EnumType.STRING)
	private TypeSatge type ; 
	
	@Enumerated(EnumType.STRING)
	private StageOF stageof ;
	
	@Enumerated(EnumType.STRING)
	private Etat status ;
	
	private String sujet;
	
	private String description;
	
	private String cv;
	
	private String demande;
	
	
	@OneToOne(mappedBy="stagedemande")
	private Stagiaire user;
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy="stagedemande" ,fetch=FetchType.EAGER)
    private Set<Livrable> Livrables;
	
	
	

	public StageDemande() {
		super();
	}

	
		


	public StageDemande(String nom, int numero, String prenom, String email, String etabilssement, Date dateNaissance,
			Date dateDebut, Date datefin, Niveau diplome, Classe classe, TypeSatge type, StageOF stageof, String sujet,
			String description, String cv, String demande, Stagiaire user) {
		super();
		this.nom = nom;
		this.numero = numero;
		this.prenom = prenom;
		this.email = email;
		this.etabilssement = etabilssement;
		this.dateNaissance = dateNaissance;
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		this.diplome = diplome;
		this.classe = classe;
		this.type = type;
		this.stageof = stageof;
		this.sujet = sujet;
		this.description = description;
		this.cv = cv;
		this.demande = demande;
		this.user = user;
	}




	public StageDemande(String nom, int numero, String prenom, String email, String etabilssement, Date dateNaissance,
			Date dateDebut, Date datefin, Niveau diplome, Classe classe, TypeSatge type, StageOF stageof, Etat status,
			String sujet, String description, String cv, String demande, Stagiaire user) {
		super();
		this.nom = nom;
		this.numero = numero;
		this.prenom = prenom;
		this.email = email;
		this.etabilssement = etabilssement;
		this.dateNaissance = dateNaissance;
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		this.diplome = diplome;
		this.classe = classe;
		this.type = type;
		this.stageof = stageof;
		this.status = status;
		this.sujet = sujet;
		this.description = description;
		this.cv = cv;
		this.demande = demande;
		this.user = user;
	}






	public StageDemande(String nom, int numero, String prenom, String email, String etabilssement, Date dateNaissance,
			Date dateDebut, Date datefin, Niveau diplome, Classe classe, TypeSatge type, StageOF stageof, Etat status,
			String sujet, String description, String cv, String demande, Stagiaire user, Set<Livrable> livrables) {
		super();
		this.nom = nom;
		this.numero = numero;
		this.prenom = prenom;
		this.email = email;
		this.etabilssement = etabilssement;
		this.dateNaissance = dateNaissance;
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		this.diplome = diplome;
		this.classe = classe;
		this.type = type;
		this.stageof = stageof;
		this.status = status;
		this.sujet = sujet;
		this.description = description;
		this.cv = cv;
		this.demande = demande;
		this.user = user;
		Livrables = livrables;
	}





	public StageOF getStageof() {
		return stageof;
	}







	public void setStageof(StageOF stageof) {
		this.stageof = stageof;
	}







	public Etat getStatus() {
		return status;
	}







	public void setStatus(Etat status) {
		this.status = status;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEtabilssement() {
		return etabilssement;
	}



	public void setEtabilssement(String etabilssement) {
		this.etabilssement = etabilssement;
	}



	public Date getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDatefin() {
		return datefin;
	}



	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}



	public Niveau getDiplome() {
		return diplome;
	}



	public void setDiplome(Niveau diplome) {
		this.diplome = diplome;
	}



	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	public TypeSatge getType() {
		return type;
	}



	public void setType(TypeSatge type) {
		this.type = type;
	}



	public String getSujet() {
		return sujet;
	}



	public void setSujet(String sujet) {
		this.sujet = sujet;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCv() {
		return cv;
	}



	public void setCv(String cv) {
		this.cv = cv;
	}



	public String getDemande() {
		return demande;
	}



	public void setDemande(String demande) {
		this.demande = demande;
	}



	public Stagiaire getUser() {
		return user;
	}



	public void setUser(Stagiaire user) {
		this.user = user;
	}





	@Override
	public String toString() {
		return "StageDemande [nom=" + nom + ", numero=" + numero + ", prenom=" + prenom + ", email=" + email
				+ ", etabilssement=" + etabilssement + ", dateNaissance=" + dateNaissance + ", dateDebut=" + dateDebut
				+ ", datefin=" + datefin + ", diplome=" + diplome + ", classe=" + classe + ", type=" + type
				+ ", stageof=" + stageof + ", status=" + status + ", sujet=" + sujet + ", description=" + description
				+ ", cv=" + cv + ", demande=" + demande + ", user=" + user + "]";
	}





	

	











	


	

	
	
	
	
	
	
	
	

}
