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

import fr.istic.sir.entity.Sondage;
import fr.istic.sir.entity.SondageDate;
import fr.istic.sir.service.SondageDateService;
import fr.istic.sir.service.SondageService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class SondageDateController {
	

	@Autowired
    SondageDateService sondageDateService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/sondageDate/{idSondage}")
public ResponseEntity<SondageDate> getSondageDate(@PathVariable("idSondage") Long idSondage) {
	
	SondageDate sondageDate = sondageDateService.findOne(idSondage);
	try {
		if (sondageDate == null) {
		return new ResponseEntity(new CustomErrorType("Le sondage avec ID:  " + idSondage 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<SondageDate>(sondageDate, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/sondageDate")
public ResponseEntity<List<SondageDate>> findAll() {
List<SondageDate> sondageDates  = sondageDateService.findAll();
try {
	
	if (sondageDates.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(sondageDates, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/sondageDate")
@ResponseBody
public ResponseEntity< SondageDate > createSondage(@RequestBody  SondageDate  sondageDate, BindingResult result) {



                if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }    
                else if (sondageDateService.isSondageDateExist(sondageDate)) {
		return new ResponseEntity(new CustomErrorType("Le sondage avec le nom " + sondageDate.getIdSondage() + " existe deja."),HttpStatus.CONFLICT);
	}
                else sondageDateService.save(sondageDate);
                
    



return new ResponseEntity <SondageDate>(sondageDate, HttpStatus.CREATED);
}





@RequestMapping(method = RequestMethod.PUT, value = "/sondageDate/{idSondage}" )
@ResponseBody
public ResponseEntity< SondageDate > updateSondage(@PathVariable("idSondage") Long idSondage, @Valid @RequestBody SondageDate  sondageDate, BindingResult result) {

   


        
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (sondageDate == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information du sondage."),
			HttpStatus.NOT_FOUND);
}
        
        else sondageDateService.update(sondageDate);
        
  


return new ResponseEntity <>(sondageDate, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/sondageDate/{idSondage}")
public ResponseEntity<SondageDate> deleteReunion(@PathVariable("idSondage") Long idSondage) {
        
	SondageDate sondageDate = sondageDateService.findOne(idSondage);
                    
		if (sondageDate == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations du sondage"
                            + "ayant ce numéro" + idSondage + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		sondageDateService.delete(idSondage);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}




}
