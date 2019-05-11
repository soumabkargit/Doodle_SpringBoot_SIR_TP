package fr.istic.sir.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.SondageDate;
import fr.istic.sir.repository.SondageDateRepository;




@Transactional
@Service
public class SondageDateService {
	
	 @Autowired
	 SondageDateRepository sondageDateRepository;
	 
	 
	 public SondageDate findOne(Long idSondage) {
			return sondageDateRepository.findOne(idSondage);
}

public List<SondageDate> findAll() {
return sondageDateRepository.findAll();
}

public void save(SondageDate sondageDate) {		
	sondageDateRepository.save(sondageDate);
}

public void update(SondageDate sondageDate) {
	sondageDateRepository.save(sondageDate);
}

public void delete(Long idSondage) {
	sondageDateRepository.delete(idSondage);
}


public boolean isSondageDateExist(SondageDate sondageDate) {
	return findOne(sondageDate.getIdSondage()) != null;
}
	


	

}
