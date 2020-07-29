package tn.bfi.spring.services;


import java.util.List;

import org.springframework.stereotype.Repository;

import tn.bfi.spring.entities.StageDemande;
@Repository
public interface IDemandeStageService {
	
	public StageDemande ajouterDemande(StageDemande demande);
	public void supprimerDemande(long id);
	public List<StageDemande> retrieveAllDemande();
	public StageDemande affichage(long id);
	public StageDemande update(StageDemande demande);
	public 	Long nbrdemande();
	

}
