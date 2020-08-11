package tn.bfi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.bfi.spring.entities.StageDemande;
import tn.bfi.spring.entities.TypeSatge;


@Repository
public interface StageDemandeRepository extends CrudRepository<StageDemande, Long>{
	
	@Query("select c from StageDemande c where c.nom=:nom and c.type=:type ")
    public List<StageDemande> getDemandeByNameTypeJPQL(@Param("nom")String name, @Param("type")TypeSatge type);

}
