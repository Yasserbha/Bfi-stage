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
	public String filename = null;
	public StageDemande yasser ;
	private MultipartFile filess ;

	
	
	
	
	@Override
	public void uploadlivrable(MultipartFile file ) {
		try {
			filename =file.getOriginalFilename();
			//Files.write(Paths.get(System.getProperty("user.home")+"/bfi"),file.getBytes());
			
			file.transferTo(new File ("C:\\Users\\Yasser Bel Haj Ali\\bfi\\"+file.getOriginalFilename()));
		//	System.out.print(filename+"fileeeeLIvrableeeeeeee");
			
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
		
		return livrablerepository.getDemandeByNameTypeJPQL(id);
	}
	
	
	@Override
	public Livrable ajouterLivrable(Livrable livrable) {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		livrable.setDatePostule(date);
		livrable.setStagedemande(yasser);
		String n ;
		n =livrable.getFile() ;
		livrable.setFile(n.substring(12, n.length()));
		return livrablerepository.save(livrable);
	}
}
