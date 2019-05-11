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

import fr.istic.sir.entity.SondageDateLieu;
import fr.istic.sir.entity.SondageLieu;
import fr.istic.sir.service.SondageDateLieuService;
import fr.istic.sir.service.SondageLieuService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class SondageLieuController {
	

	@Autowired
    SondageLieuService sondageLieuService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/sondageLieu/{idSondage}")
public ResponseEntity<SondageLieu> getSondageLieu(@PathVariable("idSondage") Long idSondage) {
	
	SondageLieu sondageLieu = sondageLieuService.findOne(idSondage);
	try {
		if (sondageLieu == null) {
		return new ResponseEntity(new CustomErrorType("Le sondage avec ID: " + idSondage 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<SondageLieu>(sondageLieu, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/sondageLieu")
public ResponseEntity<List<SondageLieu>> findAll() {
List<SondageLieu> sondageLieux  = sondageLieuService.findAll();
try {
	
	if (sondageLieux.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(sondageLieux, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/sondageLieu")
@ResponseBody
public ResponseEntity< SondageLieu > createSondage(@RequestBody SondageLieu  sondageLieu, BindingResult result) {



                sondageLieuService.save(sondageLieu);
                
       
              



return new ResponseEntity <SondageLieu>(sondageLieu, HttpStatus.CREATED);
}





@RequestMapping(method = RequestMethod.PUT, value = "/sondageLieu/{idSondage}" )
@ResponseBody
public ResponseEntity< SondageLieu > updateSondage(@PathVariable("idSondage") Long idSondage, @Valid @RequestBody  SondageLieu  sondageLieu, BindingResult result) {

   


if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (sondageLieu == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information du sondage."),
			HttpStatus.NOT_FOUND);
}
        
        else sondageLieuService.update(sondageLieu);




return new ResponseEntity <>(sondageLieu, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/sondageLieu/{idSondage}")
public ResponseEntity<SondageLieu> deleteReunion(@PathVariable("idSondage") Long idSondage) {
        
	SondageLieu sondageLieu = sondageLieuService.findOne(idSondage);
                    
		if (sondageLieu == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations du sondage"
                            + "ayant ce numéro" + idSondage + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		sondageLieuService.delete(idSondage);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}





}
