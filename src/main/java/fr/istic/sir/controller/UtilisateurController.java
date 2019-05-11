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
import fr.istic.sir.entity.Utilisateur;
import fr.istic.sir.service.UtilisateurService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class UtilisateurController {
	
	

	@Autowired
    UtilisateurService utilisateurService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/utilisateur/{email}")
public ResponseEntity<Utilisateur> getParticipant(@PathVariable("email") String email) {
	
	Utilisateur utilisateur = utilisateurService.findOne(email);
	try {
		if (utilisateur == null) {
		return new ResponseEntity(new CustomErrorType("L utilisateur avec email  " + email 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/utilisateur")
public ResponseEntity<List<Utilisateur>> findAll() {
List<Utilisateur> utilisateurs  = utilisateurService.findAll();
try {
	
	if (utilisateurs.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/utilisateur")
@ResponseBody
public ResponseEntity< Utilisateur > createUtilisateur(@RequestBody Utilisateur  utilisateur, BindingResult result) {

                utilisateurService.save(utilisateur);
                
  


return new ResponseEntity <Utilisateur>(utilisateur, HttpStatus.CREATED);
}





@RequestMapping(method = RequestMethod.PUT, value = "/utilisateur/{email}" )
@ResponseBody
public ResponseEntity<Utilisateur > updateParticipent(@PathVariable("email") String email, @Valid @RequestBody Utilisateur  utilisateur, BindingResult result) {

      
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (utilisateur == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information de l utilisateur."),
			HttpStatus.NOT_FOUND);
}
        
        else utilisateurService.update(utilisateur);
     



return new ResponseEntity <>(utilisateur, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/utilisateur/{email}")
public ResponseEntity<Utilisateur> deleteParticipant(@PathVariable("email") String email) {
        
	Utilisateur utilisateur = utilisateurService.findOne(email);
                    
		if (utilisateur == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations de l utilisateur"
                            + "ayant ce numéro" + email + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		utilisateurService.delete(email);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


	

}
