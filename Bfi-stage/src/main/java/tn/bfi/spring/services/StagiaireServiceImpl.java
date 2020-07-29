package tn.bfi.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.bfi.spring.entities.Stagiaire;
import tn.bfi.spring.repository.StagiaireRepository;

@Service
public class StagiaireServiceImpl implements IStagiaireService {

	private static final Logger L= LogManager.getLogger(StagiaireServiceImpl.class);
		
	@Autowired
	StagiaireRepository stagiairerepository;
	
	@Override
	public Stagiaire ajouterStagiaire(Stagiaire stagiaire) {
		
		return stagiairerepository.save(stagiaire);
	}

	@Override
	public void supprimerStagiaire(long id) {
		stagiairerepository.deleteById(id);
		
	}

	@Override
	public List<Stagiaire> retrieveAllStagiaire() {
		return(List<Stagiaire>)stagiairerepository.findAll();
	}

	@Override
	public Stagiaire affichage(long id) {
		Stagiaire u= stagiairerepository.findById(id).orElse(null);;
		L.info("retrive Admin by id ++++:"+u);
		return u;
	}

	@Override
	public Stagiaire update(Stagiaire stagiaire) {
		
		return stagiairerepository.save(stagiaire) ;
	}

}
