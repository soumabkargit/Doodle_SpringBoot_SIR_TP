package fr.istic.sir.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.sir.entity.Allergie;
import fr.istic.sir.entity.Participant;
import fr.istic.sir.service.ParticipantService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ParticipantController {

	@Autowired
    ParticipantService participantService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/participant/{email}")
public ResponseEntity<Participant> getParticipant(@PathVariable("email") String email) {
	
	Participant participant = participantService.findOne(email);
	try {
		if (participant == null) {
		return new ResponseEntity(new CustomErrorType("Le participant avec email  " + email 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<Participant>(participant, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/participant")
public ResponseEntity<List<Participant>> findAll() {
List<Participant> participants  = participantService.findAll();
try {
	
	if (participants.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(participants, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/participant")
@ResponseBody
public ResponseEntity< Participant > createParticipant(@RequestBody  Participant  participant, BindingResult result) {
     
                 participantService.save(participant);
               
return new ResponseEntity <Participant>(participant, HttpStatus.CREATED);
}



@RequestMapping(method = RequestMethod.PUT, value = "/participant/{email}" )
@ResponseBody
public ResponseEntity<Participant > updateParticipent(@PathVariable("email") String email, @Valid @RequestBody Participant  participant, BindingResult result) {
      
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (participant == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information du participant."),
			HttpStatus.NOT_FOUND);
}
        
        else participantService.update(participant);
        
return new ResponseEntity <>(participant, HttpStatus.OK);
}




@RequestMapping(method = RequestMethod.DELETE, value = "/participant/{email}")
public ResponseEntity<Participant> deleteParticipant(@PathVariable("email") String email) {
        
	Participant participant = participantService.findOne(email);
                    
		if (participant == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations du travailleur"
                            + "ayant ce numéro" + email + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		participantService.delete(email);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}
