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
	
	
	@Column(unique=true,name = "adresseEmail")
	private String email;
	
	@Enumerated(EnumType.STRING)
	Sexe Homme;
	
	@OneToOne
	private StageDemande stagedemande;
	
	
	

	public Stagiaire() {
		super();
	}
	
	

	public Stagiaire(String name, String lastname, int age, Sexe homme) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		Homme = homme;
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

	public Sexe getHomme() {
		return Homme;
	}

	public void setHomme(Sexe homme) {
		Homme = homme;
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





	
	
	

}
