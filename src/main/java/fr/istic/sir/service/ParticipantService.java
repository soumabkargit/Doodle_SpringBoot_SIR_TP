package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.Participant;
import fr.istic.sir.repository.ParticipantRepository;




@Transactional
@Service
public class ParticipantService {
	
	 @Autowired
	 ParticipantRepository participantRepository;
	 
	 
	 
 public Participant findOne(String email) {
			return participantRepository.findOne(email);
}

public List<Participant> findAll() {
  return participantRepository.findAll();
}

public void save(Participant participant) {		
	participantRepository.save(participant);
}

public void update(Participant participant) {
	participantRepository.save(participant);
}

public void delete(String email) {
	participantRepository.delete(email);
}
  
 
 public boolean isParticipantExist(Participant participant) {
	return findOne(participant.getEmailUtilisateur()) != null;
}
	

}
