package tn.bfi.spring.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import tn.bfi.spring.entities.Livrable;
import tn.bfi.spring.entities.StageDemande;


@RepositoryRestResource
public interface ILivrableService {
	public Livrable ajouterLivrable(Livrable livrable);
	public List<Livrable> getLivrableByDemandeJPQL(Long stagedemandeid);
	public void uploadlivrable(MultipartFile file );
	public StageDemande getDemandeById(Long id);


}
