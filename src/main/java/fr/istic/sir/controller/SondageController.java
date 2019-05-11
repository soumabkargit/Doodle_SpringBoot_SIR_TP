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

import fr.istic.sir.entity.Reunion;
import fr.istic.sir.entity.Sondage;
import fr.istic.sir.service.ReunionService;
import fr.istic.sir.service.SondageService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class SondageController {

	@Autowired
    SondageService sondageService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/sondage/{idSondage}")
public ResponseEntity<Sondage> getSondage(@PathVariable("idSondage") Long idSondage) {
	
	Sondage sondage = sondageService.findOne(idSondage);
	try {
		if (sondage == null) {
		return new ResponseEntity(new CustomErrorType("Le sondage avec ID: " + idSondage 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<Sondage>(sondage, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/sondage")
public ResponseEntity<List<Sondage>> findAll() {
List<Sondage> sondages  = sondageService.findAll();
try {
	
	if (sondages.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(sondages, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/sondage")
@ResponseBody
public ResponseEntity< Sondage > createSondage(@RequestBody Sondage  sondage, BindingResult result) {



                if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }    
                else if (sondageService.isSondageExist(sondage)) {
		return new ResponseEntity(new CustomErrorType("Le sondage avec le libellé " + sondage.getIdSondage() + " existe deja."),HttpStatus.CONFLICT);
	}
                else sondageService.save(sondage);
                
       



return new ResponseEntity <Sondage>(sondage, HttpStatus.CREATED);
}





@RequestMapping(method = RequestMethod.PUT, value = "/sondage/{idSondage}" )
@ResponseBody
public ResponseEntity< Sondage > updateSondage(@PathVariable("idSondage") Long idSondage, @Valid @RequestBody  Sondage sondage, BindingResult result) {

    


if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (sondage == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information du sondage."),
			HttpStatus.NOT_FOUND);
}
        
        else sondageService.update(sondage);
        



return new ResponseEntity <>(sondage, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/sondage/{idSondage}")
public ResponseEntity<Sondage> deleteReunion(@PathVariable("idSondage") Long idSondage) {
        
	Sondage sondage = sondageService.findOne(idSondage);
                    
		if (sondage == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations du sondage"
                            + "ayant ce numéro" + idSondage + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		sondageService.delete(idSondage);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}




}
