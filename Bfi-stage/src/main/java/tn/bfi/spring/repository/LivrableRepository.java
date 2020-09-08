package tn.bfi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.bfi.spring.entities.Livrable;
import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.TypeSatge;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface LivrableRepository  extends CrudRepository<Livrable, Long> {
	@Query("select c from Livrable c join c.stagedemande e where e.id=:stagedemandeId")
    public List<Livrable> getLivrableByDemandeJPQL(@Param("stagedemandeId")Long stagedemandeid);
	
	@Query("select c from StageDemande c where c.id=:id")
    public StageDemande getDemandeByNameTypeJPQL(@Param("id")Long id);
	
	@Query("select c from Livrable c where c.file=:namefile")
    public Livrable getLivrableByfileJPQL(@Param("namefile")String namefile);

}
