package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.Allergie;
import fr.istic.sir.repository.AllergieRepository;




@Transactional
@Service
public class AllergieService {

	 @Autowired
	 AllergieRepository allergieRepository;
	 
	 
	 
 public Allergie findOne(Long idAllergie) {
			return allergieRepository.findOne(idAllergie);
}

public List<Allergie> findAll() {
  return allergieRepository.findAll();
}

public void save(Allergie allergie) {		
	allergieRepository.save(allergie);
}

public void update(Allergie allergie) {
	allergieRepository.save(allergie);
}

public void delete(Long idAllergie) {
	allergieRepository.delete(idAllergie);
}
  
 
 public boolean isAllergieExist(Allergie allergie) {
	return findOne(allergie.getIdAllergie()) != null;
}
	 	
}
