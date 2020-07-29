package tn.bfi.spring.services;

import java.util.List;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.Stagiaire;

public interface IStagiaireService {
	
	public Stagiaire ajouterStagiaire(Stagiaire stagiaire);
	public void supprimerStagiaire(long id);
	public List<Stagiaire> retrieveAllStagiaire();
	public Stagiaire affichage(long id);
	public Stagiaire update(Stagiaire stagiaire);

}
