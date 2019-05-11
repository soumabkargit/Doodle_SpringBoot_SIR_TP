package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.SondageDateLieu;
import fr.istic.sir.repository.SondageDateLieuRepository;





@Transactional
@Service
public class SondageDateLieuService {
	
	@Autowired
	SondageDateLieuRepository sondageDateLieuRepository;

	
	 
	 public SondageDateLieu findOne(Long idSondage) {
			return sondageDateLieuRepository.findOne(idSondage);
}

public List<SondageDateLieu> findAll() {
return sondageDateLieuRepository.findAll();
}

public void save(SondageDateLieu sondageDateLieu) {		
	sondageDateLieuRepository.save(sondageDateLieu);
}

public void update(SondageDateLieu sondageDateLieu) {
	sondageDateLieuRepository.save(sondageDateLieu);
}

public void delete(Long idSondage) {
	sondageDateLieuRepository.delete(idSondage);
}


public boolean isSondageDateLieuExist(SondageDateLieu sondageDateLieu) {
	return findOne(sondageDateLieu.getIdSondage()) != null;
}
	


	
	
}
