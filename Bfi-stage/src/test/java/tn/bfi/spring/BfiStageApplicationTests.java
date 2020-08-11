package tn.bfi.spring;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.bfi.spring.entities.Classe;
import tn.bfi.spring.entities.Niveau;
import tn.bfi.spring.entities.Sexe;
import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.StageOF;
import tn.bfi.spring.entities.Stagiaire;
import tn.bfi.spring.entities.TypeSatge;
import tn.bfi.spring.services.IDemandeStageService;
import tn.bfi.spring.services.IStagiaireService;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class BfiStageApplicationTests {
	@Autowired
	IStagiaireService sta;
	
	@Autowired
	IDemandeStageService dem;
	Stagiaire x ;
	StageDemande y;
	
	@Test
	public void contextLoads() throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date debut;
		Date fin;
		Date Naissance;
		
		debut = dateFormat.parse("01/02/2015");
		fin = dateFormat.parse("01/02/2015");
		Naissance = dateFormat.parse("01/02/2015");
		/*
		Stagiaire x = new Stagiaire("yasser","bha",24,"test","yasser.belhajali@esprit.tn",Sexe.homme);
		sta.ajouterStagiaire(x);
		dem.ajouterDemande(demande);
		x.setStagedemande(demande);
		sta.ajouterStagiaire(x);
		*/
		
StageDemande demande = new StageDemande("yasser",97105262,"bha","yasser@esprit.tn","esprit",Naissance,debut,fin,Niveau.Doctorat,Classe.Deuxieme_année,TypeSatge.PFE,StageOF.Obligatoire,"test","test","test","test");
dem.ajouterDemande(demande);
		
		
		
	}

}
