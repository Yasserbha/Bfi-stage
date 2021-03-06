package tn.bfi.spring.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.bfi.spring.entities.Classe;
import tn.bfi.spring.entities.Etat;
import tn.bfi.spring.entities.Livrable;
import tn.bfi.spring.entities.Niveau;
import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.StageOF;
import tn.bfi.spring.entities.TypeSatge;
import tn.bfi.spring.repository.StageDemandeRepository;
import tn.bfi.spring.services.IDemandeStageService;
import tn.bfi.spring.services.IEmailService;

@CrossOrigin(origins = "*")
@RestController
public class StageDemandeController {
	
	@Autowired
	private IEmailService emailService;
	@Autowired
	StageDemandeRepository repo ;
	@Autowired
	IDemandeStageService stage;
	

	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-StageDemande
		@GetMapping("/retrieve-all-StageDemande")
		@ResponseBody
		public List<StageDemande> getSatgeDemande() {
		List<StageDemande> list= stage.retrieveAllDemande();
		return list;
		}
		// http://localhost:8081/SpringMVC/servlet/retrieve-StageDemande/{StageDemande-id}
		@GetMapping("/retrieve-StageDemande/{StageDemande-id}")
		@ResponseBody
		public StageDemande retrieveSaleAd(@PathVariable("StageDemande-id") Long StageDemandeId) {
		return stage.affichage(StageDemandeId);
		}
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-StageDemande
		@PostMapping("/add-StageDemande")
		@ResponseBody
		public StageDemande addSaleAd(@RequestBody StageDemande u) throws Exception {
			StageDemande user= stage.ajouterDemande(u);
			stage.run("test");
			
		return user;
		}
		
		// http://localhost:8081/SpringMVC/servlet/remove-StageDemande/{StageDemande-id}
		@DeleteMapping("/remove-StageDemande/{StageDemande-id}")
		@ResponseBody
		public void removeSaleAd(@PathVariable("StageDemande-id") Long StageDemandeId) {
			stage.supprimerDemande(StageDemandeId);
		}
		// http://localhost:8081/SpringMVC/servlet/modify-StageDemande
		
		@PutMapping("/modify-StageDemande/{id}")
		@ResponseBody
		public StageDemande modifySaleAd(@RequestBody StageDemande demande ,@PathVariable("id") Long idDemande) {
			demande.setId(idDemande);
			System.out.println(demande+"yassssssss");
		return stage.update(demande);
		}
		
		@PostMapping("/add-Image")
		public void uploadFile(@RequestParam("file")MultipartFile file){
			stage.uploadFile(file);
			
		}
		
		@PostMapping("/add-Image2")
		public void uploadFile2(@RequestParam("file")MultipartFile file){
			stage.uploadFile2(file);
			}
			
		
		 // URL : http://localhost:8081/SpringMVC/servlet/getSalaireByEmployeIdJPQL/2
	    @GetMapping(value = "getCustomerBynameroleJPQL/{name}/{type}/{etat}")    
	    @ResponseBody
		public List<StageDemande> getCustomerBynameroleJPQL(@PathVariable("name")String name,@PathVariable("type")TypeSatge type,@PathVariable("etat")Etat etat) {
			return repo.getDemandeByNameTypeJPQL(name, type,etat);
		}
	    @GetMapping(value = "getCustomerBynameroleJPQL/{name}")    
	    @ResponseBody
		public List<StageDemande> getCustomerBynameJPQL(@PathVariable("name")String name) {
			return repo.getDemandeByNameJPQL(name);
		}
	    @GetMapping(value = "getCustomerBynameroleJPQL/{type}/{etat}")    
	    @ResponseBody
		public List<StageDemande> getCustomerByetatroleJPQL(@PathVariable("type")TypeSatge type,@PathVariable("etat")Etat etat) {
			return repo.getDemandeByetatTypeJPQL(type,etat);
		}
	   /* 
	    @GetMapping(path="/cvStagiaire/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	    	StageDemande p= repositorydemande.findById(id).get();
	    	System.out.print(p.getCv()+"le cv est laaaaaaa");
	        return null ;
	    }*/
	    @GetMapping(path="/cvProduct/{id}",produces = MediaType.APPLICATION_PDF_VALUE)
	    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	    	StageDemande p=repo.findById(id).get();
	        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/bficv/"+p.getCv()));
	    }
	    
		
}
