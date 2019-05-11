package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.PreferenceAlimentaire;
import fr.istic.sir.repository.PreferenceAlimentaireRepository;




@Transactional
@Service
public class PreferenceAlimentaireService {

	

	 @Autowired
	 PreferenceAlimentaireRepository preferenceAlimentaireRepository;
	 
	 
	 
public PreferenceAlimentaire findOne(Long idPreferenceAlimentaire) {
			return preferenceAlimentaireRepository.findOne(idPreferenceAlimentaire);
}

public List<PreferenceAlimentaire> findAll() {
 return preferenceAlimentaireRepository.findAll();
}

public void save(PreferenceAlimentaire preferenceAlimentaire) {		
	preferenceAlimentaireRepository.save(preferenceAlimentaire);
}

public void update(PreferenceAlimentaire preferenceAlimentaire) {
	preferenceAlimentaireRepository.save(preferenceAlimentaire);
}

public void delete(Long idPreferenceAlimentaire) {
	preferenceAlimentaireRepository.delete(idPreferenceAlimentaire);
}
 

public boolean isPreferenceAlimentaireExist(PreferenceAlimentaire preferenceAlimentaire) {
	return findOne(preferenceAlimentaire.getIdPreferenceAlimentaire()) != null;
}
	
	
	
}
