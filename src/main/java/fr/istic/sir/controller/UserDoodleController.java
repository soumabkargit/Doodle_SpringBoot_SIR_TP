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
import fr.istic.sir.entity.UserDoodle;
import fr.istic.sir.service.UserDoodleService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class UserDoodleController {

	@Autowired
	UserDoodleService userDoodleService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/userDoodle/{email}")
public ResponseEntity<UserDoodle> getReunion(@PathVariable("email") String email) {
	
	UserDoodle userDoodle = userDoodleService.findOne(email);
	try {
		if (userDoodle == null) {
		return new ResponseEntity(new CustomErrorType("L utilisateur avec email  " + email 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<UserDoodle>(userDoodle, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/userDoodle")
public ResponseEntity<List<UserDoodle>> findAll() {
List<UserDoodle> userDoodles  = userDoodleService.findAll();
try {
	
	if (userDoodles.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(userDoodles, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/userDoodle")
@ResponseBody
public ResponseEntity< UserDoodle > createReunion(@RequestBody UserDoodle  userDoodle, BindingResult result) {


                 userDoodleService.save(userDoodle);
                
 

return new ResponseEntity <UserDoodle>(userDoodle, HttpStatus.CREATED);
}




@RequestMapping(method = RequestMethod.PUT, value = "/userDoodle/{email}" )
@ResponseBody
public ResponseEntity<UserDoodle > updateReunion(@PathVariable("email") String email, @Valid @RequestBody  UserDoodle  userDoodle, BindingResult result) {

    
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (userDoodle == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information de l utilisateur."),
			HttpStatus.NOT_FOUND);
}
        
        else userDoodleService.update(userDoodle);



return new ResponseEntity <>(userDoodle, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/userDoodle/{email}")
public ResponseEntity<UserDoodle> deleteReunion(@PathVariable("email") String email) {
        
	UserDoodle userDoodle = userDoodleService.findOne(email);
                    
		if (userDoodle == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations de l utilisateur"
                            + "ayant ce numéro" + email + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		userDoodleService.delete(email);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}




}
