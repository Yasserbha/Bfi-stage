package tn.bfi.spring.services;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.TypeSatge;
@Repository
public interface IDemandeStageService {
	
	public StageDemande ajouterDemande(StageDemande demande);
	public void supprimerDemande(long id);
	public List<StageDemande> retrieveAllDemande();
	public StageDemande affichage(long id);
	public StageDemande update(StageDemande demande);
	public 	Long nbrdemande();
	public void uploadFile(MultipartFile file);
	 public List<StageDemande> getDemandeByNameTypeJPQL(String name, TypeSatge type);
	

}
