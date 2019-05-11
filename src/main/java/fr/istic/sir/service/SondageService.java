package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.Sondage;
import fr.istic.sir.repository.SondageRepository;




@Transactional
@Service
public class SondageService {

	
	 @Autowired
	 SondageRepository sondageRepository;
	 
	 public Sondage findOne(Long idSondage) {
			return sondageRepository.findOne(idSondage);
}

public List<Sondage> findAll() {
return sondageRepository.findAll();
}

public void save(Sondage sondage) {		
	sondageRepository.save(sondage);
}

public void update(Sondage sondage) {
	sondageRepository.save(sondage);
}

public void delete(Long idSondage) {
	sondageRepository.delete(idSondage);
}


public boolean isSondageExist(Sondage sondage) {
	return findOne(sondage.getIdSondage()) != null;
}
	


	
	
}
