package tn.bfi.spring.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.bfi.spring.entities.Livrable;
import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.repository.LivrableRepository;
import tn.bfi.spring.repository.StageDemandeRepository;

@Service
public class LivrableServiceImpl implements ILivrableService {
	
	private static final Logger L= LogManager.getLogger(LivrableServiceImpl.class);

	@Autowired
	LivrableRepository livrablerepository;
	
	@Autowired
	IDemandeStageService servicedemande; 
	
	
	public Long IdDemande ;
	public String filename;
	public StageDemande yasser ;

	
	
	
	
	@Override
	public void uploadlivrable(MultipartFile file ) {
		try {
			StageDemande x = new StageDemande();
			filename = file.getOriginalFilename();
			file.transferTo(new File ("C:\\livrable\\"+file.getOriginalFilename()));
			System.out.print(filename+"uplodefile");
		
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public List<Livrable> getLivrableByDemandeJPQL(Long stagedemandeid) {
		IdDemande =stagedemandeid;
		getDemandeById(stagedemandeid);
		return livrablerepository.getLivrableByDemandeJPQL(stagedemandeid);
	}
	@Override
	public StageDemande getDemandeById(Long id) {
		 yasser = livrablerepository.getDemandeByNameTypeJPQL(id);
		 System.out.print(yasser.getEmail()+"tessst");
		 System.out.print(yasser+"tessst");
		return livrablerepository.getDemandeByNameTypeJPQL(id);
	}
	
	
	@Override
	public Livrable ajouterLivrable(Livrable livrable) {
		
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		livrable.setDatePostule(date);
		livrable.setStagedemande(yasser);
		livrable.setFile(filename);
		System.out.print(livrable+"ajouteeeeeeeeeer");
		return livrablerepository.save(livrable);
	}


	


	


	
	

}
