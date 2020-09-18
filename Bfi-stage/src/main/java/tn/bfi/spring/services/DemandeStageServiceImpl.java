package tn.bfi.spring.services;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.bfi.spring.entities.Classe;
import tn.bfi.spring.entities.Etat;
import tn.bfi.spring.entities.Niveau;
import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.StageOF;
import tn.bfi.spring.entities.Stagiaire;
import tn.bfi.spring.entities.TypeSatge;
import tn.bfi.spring.repository.StageDemandeRepository;


@Service
public class DemandeStageServiceImpl implements IDemandeStageService {

	private static final Logger L= LogManager.getLogger(DemandeStageServiceImpl.class);
	@Autowired
	StageDemandeRepository demandesatgeRepository;
	@Autowired
	IStagiaireService test;
	@Autowired
	StagiaireServiceImpl serstage;
	Stagiaire x;
	
	
	public String cvname=null;
	public String demandename=null;
	
	
	


	@Override
	public void uploadFile(MultipartFile file ) {
		try {
			
			cvname = file.getOriginalFilename();
			file.transferTo(new File ("C:\\Users\\Yasser Bel Haj Ali\\bficv\\"+file.getOriginalFilename()));
			System.out.print(cvname+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaauplodefile");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void uploadFile2(MultipartFile file ) {
		try {
			
			demandename = file.getOriginalFilename();
			file.transferTo(new File ("C:\\pdf\\"+file.getOriginalFilename()));
			System.out.print(demandename+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaauplodefile");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public StageDemande ajouterDemande(StageDemande demande) {
		demande.setCv(cvname);
		demande.setDemande(demandename);
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
		StageDemande u= demandesatgeRepository.findById(id).orElse(null);
		L.info("retrive Admin by id ++++:"+u);
		return u;
	};
	

	@Override
	public StageDemande update(StageDemande demande) {
		System.out.print(demande.getId()+"tessssssssst");
		return demandesatgeRepository.save(demande);
	}

	@Override
	public Long nbrdemande() {		
		return demandesatgeRepository.count();
	}

	private final static String ACCOUNT_SID = "AC36edc7ad2c73f19b341b3c42be9cd716";
	   private final static String AUTH_ID = "6c2ef750caceb356d4a3da3ef26211ef";

	   static {
	      Twilio.init(ACCOUNT_SID, AUTH_ID);
	   }
	 
	   public void run(String email) throws Exception {
	      Message.creator(new PhoneNumber("+21697105262"), new PhoneNumber("+19137351254"),
	         "Merci pour votre intérêt pour le poste de Développeur au sein de BFI Group :"+email).create();
	   }




	

}
