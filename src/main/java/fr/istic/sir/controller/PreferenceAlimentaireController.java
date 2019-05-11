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

import fr.istic.sir.entity.Participant;
import fr.istic.sir.entity.PreferenceAlimentaire;
import fr.istic.sir.service.ParticipantService;
import fr.istic.sir.service.PreferenceAlimentaireService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class PreferenceAlimentaireController {
	
	
	@Autowired
    PreferenceAlimentaireService preferenceAlimentaireService;
  

@RequestMapping(method = RequestMethod.GET, value = "/preferenceAlimentaire/{idPreferenceAlimentaire}")
public ResponseEntity<PreferenceAlimentaire> getPreferenceAlimentaire(@PathVariable("idPreferenceAlimentaire") Long idPreferenceAlimentaire) {
	
	PreferenceAlimentaire preferenceAlimentaire = preferenceAlimentaireService.findOne(idPreferenceAlimentaire);
	try {
		if (preferenceAlimentaire == null) {
		return new ResponseEntity(new CustomErrorType("Le participant avec email  " + idPreferenceAlimentaire 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<PreferenceAlimentaire>(preferenceAlimentaire, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/preferenceAlimentaire")
public ResponseEntity<List<PreferenceAlimentaire>> findAll() {
List<PreferenceAlimentaire> preferenceAlimentaires  = preferenceAlimentaireService.findAll();
try {
	
	if (preferenceAlimentaires.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(preferenceAlimentaires, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/preferenceAlimentaire")
@ResponseBody
public ResponseEntity< PreferenceAlimentaire > createPreferenceAlimentaire(@RequestBody PreferenceAlimentaire  preferenceAlimentaire, BindingResult result) {
              
                if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }    
                else if (preferenceAlimentaireService.isPreferenceAlimentaireExist(preferenceAlimentaire)) {
		return new ResponseEntity(new CustomErrorType("Le participant avec le nom " + preferenceAlimentaire.getLibellePreferenceAlimentaire() + " existe deja."),HttpStatus.CONFLICT);
	}
                else preferenceAlimentaireService.save(preferenceAlimentaire);
   
return new ResponseEntity <PreferenceAlimentaire>(preferenceAlimentaire, HttpStatus.CREATED);
}


@RequestMapping(method = RequestMethod.PUT, value = "/preferenceAlimentaire/{idPreferenceAlimentaire}" )
@ResponseBody
public ResponseEntity< PreferenceAlimentaire > updatePreferenceAlimentaire(@PathVariable("idPreferenceAlimentaire") Long idPreferenceAlimentaire, @Valid @RequestBody  PreferenceAlimentaire  preferenceAlimentaire, BindingResult result) {
    
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (preferenceAlimentaire == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information du travailleur."),
			HttpStatus.NOT_FOUND);
}
        
        else preferenceAlimentaireService.update(preferenceAlimentaire);
  
return new ResponseEntity <>(preferenceAlimentaire, HttpStatus.OK);
}




@RequestMapping(method = RequestMethod.DELETE, value = "/preferenceAlimentaire/{idPreferenceAlimentaire}")
public ResponseEntity<PreferenceAlimentaire> deletePrefrerenceAlimentaire(@PathVariable("idPreferenceAlimentaire") Long idPreferenceAlimentaire) {
        
	PreferenceAlimentaire preferenceAlimentaire = preferenceAlimentaireService.findOne(idPreferenceAlimentaire);
                    
		if (preferenceAlimentaire == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations du travailleur"
                            + "ayant ce numéro" + idPreferenceAlimentaire + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		preferenceAlimentaireService.delete(idPreferenceAlimentaire);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

	

}
