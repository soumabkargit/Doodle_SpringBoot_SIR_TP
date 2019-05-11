package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.SondageLieu;
import fr.istic.sir.repository.SondageLieuRepository;



@Transactional
@Service
public class SondageLieuService {
	
	@Autowired
	SondageLieuRepository sondageLieuRepository;

	
	 
	 public SondageLieu findOne(Long idSondage) {
			return sondageLieuRepository.findOne(idSondage);
}

public List<SondageLieu> findAll() {
return sondageLieuRepository.findAll();
}

public void save(SondageLieu sondageLieu) {		
	sondageLieuRepository.save(sondageLieu);
}

public void update(SondageLieu sondageLieu) {
	sondageLieuRepository.save(sondageLieu);
}

public void delete(Long idSondage) {
	sondageLieuRepository.delete(idSondage);
}


public boolean isSondageLieuExist(SondageLieu sondageLieu) {
	return findOne(sondageLieu.getIdSondage()) != null;
}
	



}
