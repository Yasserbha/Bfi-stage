package tn.bfi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.Stagiaire;
import tn.bfi.spring.services.IDemandeStageService;
import tn.bfi.spring.services.IStagiaireService;


@CrossOrigin(origins = "*")
@Controller
public class StagiaireController {
	

	@Autowired
	IStagiaireService stagiaireService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Stagiaire
		@GetMapping("/retrieve-all-Stagiaire")
		@ResponseBody
		public List<Stagiaire> getStagiaire() {
		List<Stagiaire> list= stagiaireService.retrieveAllStagiaire();
		return list;
		}
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{Stagiaire-id}
		@GetMapping("/retrieve-Stagiaire/{Stagiaire-id}")
		@ResponseBody
		public Stagiaire retrieveStagiaire(@PathVariable("Stagiaire-id") Long StagiaireId) {
		return stagiaireService.affichage(StagiaireId);
		}
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-Stagiaire
		@PostMapping("/add-Stagiaire")
		@ResponseBody
		public Stagiaire addStagiaire(@RequestBody Stagiaire u) {
			Stagiaire stage= stagiaireService.ajouterStagiaire(u);
		return stage;
		}
		// http://localhost:8081/SpringMVC/servlet/remove-Stagiaire/{Stagiaire-id}
		@DeleteMapping("/remove-Stagiaire/{Stagiaire-id}")
		@ResponseBody
		public void removeStagiaire(@PathVariable("Stagiaire-id") Long StagiaireId) {
			stagiaireService.supprimerStagiaire(StagiaireId);
		}
		// http://localhost:8081/SpringMVC/servlet/modify-Stagiaire
		@PutMapping("/modify-Stagiaire")
		@ResponseBody
		public Stagiaire modifyStagiaire(@RequestBody Stagiaire stage) {
		return stagiaireService.update(stage);
		}

}
