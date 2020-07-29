package tn.bfi.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Stagiaire")
public class Stagiaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	private String name ;
	
	private String lastname;
	
	private int age ;
	
	private String mdp ;
	
	
	@Column(unique=true,name = "adresseEmail")
	private String email;
	
	@Enumerated(EnumType.STRING)
	Sexe sexe;
	
	@OneToOne
	private StageDemande stagedemande;
	
	
	

	public Stagiaire() {
		super();
	}
	
	

	



	public Stagiaire(String name, String lastname, int age, String mdp, String email, Sexe sexe) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.mdp = mdp;
		this.email = email;
		this.sexe = sexe;
	}







	public Stagiaire(String name, String lastname, int age, String mdp, String email, Sexe sexe,
			StageDemande stagedemande) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.mdp = mdp;
		this.email = email;
		this.sexe = sexe;
		this.stagedemande = stagedemande;
	}




	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public StageDemande getStagedemande() {
		return stagedemande;
	}



	public void setStagedemande(StageDemande stagedemande) {
		this.stagedemande = stagedemande;
	}





	
	
	

}
