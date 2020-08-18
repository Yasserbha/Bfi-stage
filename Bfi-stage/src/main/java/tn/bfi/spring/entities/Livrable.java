package tn.bfi.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Livrable")
public class Livrable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date datePostule;
	
	private String designation;
	
	private String file;
	
	@ManyToOne
	private StageDemande stagedemande;
	
	
	public Livrable() {
		super();
	}
	
	

	public Livrable(String designation, String file, StageDemande stagedemande) {
		super();
		this.designation = designation;
		this.file = file;
		this.stagedemande = stagedemande;
	}
	
	

	public Livrable(Date datePostule, String designation, String file, StageDemande stagedemande) {
		super();
		this.datePostule = datePostule;
		this.designation = designation;
		this.file = file;
		this.stagedemande = stagedemande;
	}
	
	


	public Date getDatePostule() {
		return datePostule;
	}



	public void setDatePostule(Date datePostule) {
		this.datePostule = datePostule;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	

	public StageDemande getStagedemande() {
		return stagedemande;
	}



	public void setStagedemande(StageDemande stagedemande) {
		this.stagedemande = stagedemande;
	}



	@Override
	public String toString() {
		return "Livrable [id=" + id + ", designation=" + designation + ", file=" + file + ", stagedemande="
				+ stagedemande + "]";
	}

	
	
	
	

}
