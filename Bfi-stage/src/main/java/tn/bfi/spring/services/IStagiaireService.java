package tn.bfi.spring.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.Stagiaire;
@Repository
public interface IStagiaireService {
	
	public Stagiaire ajouterStagiaire(Stagiaire stagiaire);
	public void supprimerStagiaire(long id);
	public List<Stagiaire> retrieveAllStagiaire();
	public Stagiaire affichage(long id);
	public Stagiaire update(Stagiaire stagiaire);
	  public Stagiaire getDemandeByNameJPQL(String name, int age);

}
