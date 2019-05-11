
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
import fr.istic.sir.service.AllergieService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class AllergieController {

	@Autowired
    AllergieService allergieService;

@RequestMapping(method = RequestMethod.GET, value = "/allergie/{idAllergie}")
public ResponseEntity<Allergie> getAllergie(@PathVariable("idAllergie") Long idAllergie) {
	
	Allergie allergie = allergieService.findOne(idAllergie);
	try {
		if (allergie == null) {
		return new ResponseEntity(new CustomErrorType("L allergie avec numero allergie" + idAllergie 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<Allergie>(allergie, HttpStatus.OK);
}

    
    
    
@RequestMapping(method = RequestMethod.GET, value = "/allergie")
public ResponseEntity<List<Allergie>> findAll() {
	List<Allergie> allergies  = allergieService.findAll();
	try {
		
		if (allergies.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	} catch (Exception e) {

	}

	return new ResponseEntity<>(allergies, HttpStatus.OK);
}




@RequestMapping(method = RequestMethod.POST, value = "/allergie")
    @ResponseBody
public ResponseEntity< Allergie > createAllergie(@RequestBody  Allergie allergie, BindingResult result) {
	
	 if (result.hasErrors()){
         return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
         }    
         else if (allergieService.isAllergieExist(allergie)) {
		return new ResponseEntity(new CustomErrorType("L allergie avec le libellé " + allergie.getLibelleAllergie() + " existe deja."),HttpStatus.CONFLICT);
	}
	 allergieService.save(allergie);
	return new ResponseEntity <Allergie>(allergie, HttpStatus.CREATED);
}


    
    @RequestMapping(method = RequestMethod.PUT, value = "/allergie/{IdAllergie}" )
    @ResponseBody
public ResponseEntity< Allergie > updateAllergie(@PathVariable("IdAllergie") long trvnum, @Valid @RequestBody  Allergie  allergie, BindingResult result) {
           
	if (result.hasErrors()){
                    return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                    }
            
		else if (allergie == null) {
	
		return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information de lallergie, donnée égale à null."),
				HttpStatus.NOT_FOUND);
	}
            
            else allergieService.update(allergie);

	return new ResponseEntity <>(allergie, HttpStatus.OK);
}
    
 
    

@RequestMapping(method = RequestMethod.DELETE, value = "/allergie/{idAllergie}")
public ResponseEntity<Allergie> deleteAllergie(@PathVariable("idAllergie") long idAllergie) {
        
	Allergie allergie = allergieService.findOne(idAllergie);
                    
		if (allergie == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations de l allergie"
                            + "ayant ce numéro" + idAllergie + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		allergieService.delete(idAllergie);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

	
}
