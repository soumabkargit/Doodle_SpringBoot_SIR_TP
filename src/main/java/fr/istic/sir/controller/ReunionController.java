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
import fr.istic.sir.entity.Reunion;
import fr.istic.sir.service.ParticipantService;
import fr.istic.sir.service.PreferenceAlimentaireService;
import fr.istic.sir.service.ReunionService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ReunionController {

	@Autowired
    ReunionService reunionService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/reunion/{idReunion}")
public ResponseEntity<Reunion> getReunion(@PathVariable("idReunion") Long idReunion) {
	
	Reunion reunion = reunionService.findOne(idReunion);
	try {
		if (reunion == null) {
		return new ResponseEntity(new CustomErrorType("La reunion avec ID :  " + idReunion 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<Reunion>(reunion, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/reunion")
public ResponseEntity<List<Reunion>> findAll() {
List<Reunion> reunions  = reunionService.findAll();
try {
	
	if (reunions.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(reunions, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/reunion")
@ResponseBody
public ResponseEntity< Reunion > createReunion(@RequestBody  Reunion  reunion, BindingResult result) {


                    
                if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }    
                else if (reunionService.isReunionExist(reunion)) {
		return new ResponseEntity(new CustomErrorType("La reunion avec le libelle : " + reunion.getIntitule() + " existe deja."),HttpStatus.CONFLICT);
	}
                else reunionService.save(reunion);
  
return new ResponseEntity <Reunion>(reunion, HttpStatus.CREATED);
}





@RequestMapping(method = RequestMethod.PUT, value = "/reunion/{idReunion}" )
@ResponseBody
public ResponseEntity< Reunion > updateReunion(@PathVariable("idReunion") Long idReunion, @Valid @RequestBody  Reunion  reunion, BindingResult result) {


        
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (reunion == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information de la reunion. Donnée égale à null."),
			HttpStatus.NOT_FOUND);
}
        
        else reunionService.update(reunion);
 


return new ResponseEntity <>(reunion, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/reunion/{idReunion}")
public ResponseEntity<Reunion> deleteReunion(@PathVariable("idReunion") Long idReunion) {
        
	Reunion reunion = reunionService.findOne(idReunion);
                    
		if (reunion == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations de la reunion"
                            + "ayant ce numéro" + idReunion + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		reunionService.delete(idReunion);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}




	
}
