package tn.bfi.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
import javax.servlet.ServletContext;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tn.bfi.spring.config.MediaTypeUtils;
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
		
		/////////////////////////////////////////////////uplode Pdf Cv ////////////
		    private static final String DIRECTORY = "C:/PDF";
		    private static final String DEFAULT_FILE_NAME = "java-tutorial.pdf";
		 
		    @Autowired
		    private ServletContext servletContext;
		 
		    // http://localhost:8080/download1?fileName=abc.zip
		    // Using ResponseEntity<InputStreamResource>
		    @RequestMapping("/download1")
		    public ResponseEntity<InputStreamResource> downloadFile1(
		            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {
		 
		        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
		        System.out.println("fileName: " + fileName);
		        System.out.println("mediaType: " + mediaType);
		 
		        File file = new File(DIRECTORY + "/" + fileName);
		        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		 
		        return ResponseEntity.ok()
		                // Content-Disposition
		                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
		                // Content-Type
		                .contentType(mediaType)
		                // Contet-Length
		                .contentLength(file.length()) //
		                .body(resource);
		    }

}
