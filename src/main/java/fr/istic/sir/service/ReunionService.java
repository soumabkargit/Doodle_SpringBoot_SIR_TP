package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.Reunion;
import fr.istic.sir.repository.ReunionRepository;




@Transactional
@Service
public class ReunionService {
	 @Autowired
	 ReunionRepository reunionRepository;
	 
	 public Reunion findOne(Long idReunion) {
			return reunionRepository.findOne(idReunion);
}

public List<Reunion> findAll() {
return reunionRepository.findAll();
}

public void save(Reunion reunion) {		
	reunionRepository.save(reunion);
}

public void update(Reunion reunion) {
	reunionRepository.save(reunion);
}

public void delete(Long idReunion) {
	reunionRepository.delete(idReunion);
}


public boolean isReunionExist(Reunion reunion) {
	return findOne(reunion.getIdReunion()) != null;
}
	


}
