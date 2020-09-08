package tn.bfi.spring.services;

import org.springframework.stereotype.Repository;

@Repository
public interface IEmailService {
	
	  public boolean SendingEmail(Long idAb);

}
