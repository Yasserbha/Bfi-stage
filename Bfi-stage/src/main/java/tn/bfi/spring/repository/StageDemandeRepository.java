package tn.bfi.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.bfi.spring.entities.Classe;
import tn.bfi.spring.entities.Etat;
import tn.bfi.spring.entities.Niveau;
import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.StageOF;
import tn.bfi.spring.entities.TypeSatge;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface StageDemandeRepository extends CrudRepository<StageDemande, Long>{
	
	@Query("select c from StageDemande c where c.nom=:nom or c.type=:type or c.status=:status ")
    public List<StageDemande> getDemandeByNameTypeJPQL(@Param("nom")String name, @Param("type")TypeSatge type,@Param("status") Etat status);

	@Query("select c from StageDemande c where c.nom=:nom")
    public List<StageDemande> getDemandeByNameJPQL(@Param("nom")String name);
	
	@Query("select c from StageDemande c where c.type=:type or c.status=:status ")
    public List<StageDemande> getDemandeByetatTypeJPQL( @Param("type")TypeSatge type,@Param("status") Etat status);


}
