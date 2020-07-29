package tn.bfi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.services.IDemandeStageService;



@Controller
public class StageDemandeController {
	
	@Autowired
	IDemandeStageService stage;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-users
		@GetMapping("/retrieve-all-StageDemande")
		@ResponseBody
		public List<StageDemande> getSatgeDemande() {
		List<StageDemande> list= stage.retrieveAllDemande();
		return list;
		}
		// http://localhost:8081/SpringMVC/servlet/retrieve-user/{SaleAd-id}
		@GetMapping("/retrieve-StageDemande/{StageDemande-id}")
		@ResponseBody
		public StageDemande retrieveSaleAd(@PathVariable("StageDemande-id") Long StageDemandeId) {
		return stage.affichage(StageDemandeId);
		}
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
		@PostMapping("/add-StageDemande")
		@ResponseBody
		public StageDemande addSaleAd(@RequestBody StageDemande u) {
			StageDemande user= stage.ajouterDemande(u);
		return user;
		}
		// http://localhost:8081/SpringMVC/servlet/remove-user/{user-id}
		@DeleteMapping("/remove-StageDemande/{StageDemande-id}")
		@ResponseBody
		public void removeSaleAd(@PathVariable("StageDemande-id") Long StageDemandeId) {
			stage.supprimerDemande(StageDemandeId);
		}
		// http://localhost:8081/SpringMVC/servlet/modify-user
		@PutMapping("/modify-StageDemande")
		@ResponseBody
		public StageDemande modifySaleAd(@RequestBody StageDemande demande) {
		return stage.update(demande);
		}

	
}
