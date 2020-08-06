package tn.bfi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.bfi.spring.entities.Stagiaire;
import tn.bfi.spring.entities.TypeSatge;
@Repository
public interface StagiaireRepository extends CrudRepository<Stagiaire, Long> {
	
	@Query("select c from Stagiaire c where c.name=:nom and c.age=:age ")
    public Stagiaire getDemandeByNameJPQL(@Param("nom")String name, @Param("age")int age);

}
