package fr.istic.sir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.UserDoodle;
import fr.istic.sir.repository.UserDoodleRepository;



@Transactional
@Service
public class UserDoodleService {
	
	@Autowired
	UserDoodleRepository userDoodleRepository;

	
	 
	 public UserDoodle findOne(String email) {
			return userDoodleRepository.findOne(email);
}

public List<UserDoodle> findAll() {
return userDoodleRepository.findAll();
}

public void save(UserDoodle userDoodle) {		
	userDoodleRepository.save(userDoodle);
}

public void update(UserDoodle userDoodle) {
	userDoodleRepository.save(userDoodle);
}

public void delete(String email) {
	userDoodleRepository.delete(email);
}


public boolean isUserDoodleExist(UserDoodle userDoodle) {
	return findOne(userDoodle.getEmailUtilisateur()) != null;
}
	

}
