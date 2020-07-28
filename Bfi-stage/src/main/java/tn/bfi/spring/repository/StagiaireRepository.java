package tn.bfi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.bfi.spring.entities.Stagiaire;
@Repository
public interface StagiaireRepository  extends CrudRepository<Stagiaire, Long> {

}
