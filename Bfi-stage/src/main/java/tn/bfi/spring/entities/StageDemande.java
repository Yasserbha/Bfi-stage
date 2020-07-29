package tn.bfi.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String name ;
	
	@Column(name ="phoneNumber")
	private int numero;
	
	private String lastname ;
	
	private String etabilssement ;

	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date datefin;
	
	@Enumerated(EnumType.STRING)
	private Niveau niv ;

	@Enumerated(EnumType.STRING)
	private TypeSatge type ; 
	
	private String sujet;
	
	private String cv;
	
	@OneToOne(mappedBy="stagedemande")
	private Stagiaire user;
	
	

	public StageDemande() {
		super();
	}
	
	
	

	public StageDemande(String name, int numero, String lastname, String etabilssement,
			Date dateDebut, Date datefin, Niveau niv, TypeSatge type, String sujet, String cv, Stagiaire user) {
		super();
		this.name = name;
		this.numero = numero;
		this.lastname = lastname;
		this.etabilssement = etabilssement;	
		this.dateDebut = dateDebut;
		this.datefin = datefin;
		this.niv = niv;
		this.type = type;
		this.sujet = sujet;
		this.cv = cv;
		this.user = user;
	}




	




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEtabilssement() {
		return etabilssement;
	}

	public void setEtabilssement(String etabilssement) {
		this.etabilssement = etabilssement;
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

	public Niveau getNiv() {
		return niv;
	}

	public void setNiv(Niveau niv) {
		this.niv = niv;
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

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	
	

}
