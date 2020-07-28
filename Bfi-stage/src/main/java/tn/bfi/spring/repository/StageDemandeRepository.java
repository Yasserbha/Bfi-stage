package tn.bfi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.bfi.spring.entities.StageDemande;

@Repository
public interface StageDemandeRepository extends CrudRepository<StageDemande, Long>{

}
