package tn.bfi.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.repository.StageDemandeRepository;

@Service
public class DemandeSatgeServiceImpl implements IDemandeSatgeService {

	private static final Logger L= LogManager.getLogger(DemandeSatgeServiceImpl.class);
	@Autowired
	StageDemandeRepository demandesatgeRepository;
	
	@Override
	public StageDemande ajouterDemande(StageDemande demande) {
		return demandesatgeRepository.save(demande);
	}

	@Override
	public void supprimerDemande(long id) {
		demandesatgeRepository.deleteById(id);
		
	}

	@Override
	public List<StageDemande> retrieveAllDemande() {
		return (List<StageDemande>)demandesatgeRepository.findAll();
	}

	@Override
	public StageDemande affichage(long id) {
		StageDemande u= demandesatgeRepository.findById(id).orElse(null);;
		L.info("retrive Admin by id ++++:"+u);
		return u;
	};
	

	@Override
	public StageDemande update(StageDemande demande) {
	
		return demandesatgeRepository.save(demande);
	}

	@Override
	public Long nbrdemande() {		
		return demandesatgeRepository.count();
	}

}
