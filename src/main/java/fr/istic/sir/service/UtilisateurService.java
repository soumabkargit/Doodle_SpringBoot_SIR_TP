package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.Utilisateur;
import fr.istic.sir.repository.UtilisateurRepository;



@Transactional
@Service
public class UtilisateurService {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

	
	 
	 public Utilisateur findOne(String email) {
			return utilisateurRepository.findOne(email);
}

public List<Utilisateur> findAll() {
return utilisateurRepository.findAll();
}

public void save(Utilisateur utilisateur) {		
	utilisateurRepository.save(utilisateur);
}

public void update(Utilisateur utilisateur) {
	utilisateurRepository.save(utilisateur);
}

public void delete(String email) {
	utilisateurRepository.delete(email);
}


public boolean isUtilisateurExist(Utilisateur utilisateur) {
	return findOne(utilisateur.getEmailUtilisateur()) != null;
}
	


}
