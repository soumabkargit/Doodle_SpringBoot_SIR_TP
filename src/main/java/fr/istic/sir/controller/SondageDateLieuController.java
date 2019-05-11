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

import fr.istic.sir.entity.SondageDate;
import fr.istic.sir.entity.SondageDateLieu;
import fr.istic.sir.service.SondageDateLieuService;
import fr.istic.sir.service.SondageDateService;
import fr.istic.sir.util.CustomErrorType;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/doodle", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class SondageDateLieuController {
	

	@Autowired
    SondageDateLieuService sondageDateLieuService;
    
    
    

@RequestMapping(method = RequestMethod.GET, value = "/sondageDateLieu/{idSondage}")
public ResponseEntity<SondageDateLieu> getSondageDate(@PathVariable("idSondage") Long idSondage) {
	
	SondageDateLieu sondageDateLieu = sondageDateLieuService.findOne(idSondage);
	try {
		if (sondageDateLieu == null) {
		return new ResponseEntity(new CustomErrorType("Le participant avec email  " + idSondage 
				+ " n'existe pas dans la base de donnée"), HttpStatus.NOT_FOUND);
		}
	} catch (Exception e) {
		
	}
        
	return new ResponseEntity<SondageDateLieu>(sondageDateLieu, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.GET, value = "/sondageDateLieu")
public ResponseEntity<List<SondageDateLieu>> findAll() {
List<SondageDateLieu> sondageDateLieux  = sondageDateLieuService.findAll();
try {
	
	if (sondageDateLieux.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
} catch (Exception e) {

}

return new ResponseEntity<>(sondageDateLieux, HttpStatus.OK);
}



@RequestMapping(method = RequestMethod.POST, value = "/sondageDateLieu")
@ResponseBody
public ResponseEntity< SondageDateLieu > createSondage(@RequestBody  SondageDateLieu  sondageDateLieu, BindingResult result) {



                    
                	 sondageDateLieuService.save(sondageDateLieu);
                
       
                




return new ResponseEntity <SondageDateLieu>(sondageDateLieu, HttpStatus.CREATED);
}





@RequestMapping(method = RequestMethod.PUT, value = "/sondageDateLieu/{idSondage}" )
@ResponseBody
public ResponseEntity<List< SondageDateLieu >> updateSondage(@PathVariable("idSondage") Long idSondage, @Valid @RequestBody List< SondageDateLieu > sondageDateLieux, BindingResult result) {

    

try {
            Iterator<SondageDateLieu> iterator = sondageDateLieux.iterator();
            while(iterator.hasNext()){ 
            	SondageDateLieu sondageDateLieu = iterator.next(); 
        
if (result.hasErrors()){
                return new ResponseEntity(new CustomErrorType("Données non conformes"),HttpStatus.BAD_REQUEST);
                }
        
	else if (sondageDateLieu == null) {

	return new ResponseEntity(new CustomErrorType("Impossible de modifier l'information du travailleur."),
			HttpStatus.NOT_FOUND);
}
        
        else sondageDateLieuService.update(sondageDateLieu);
        
            }
} catch (Exception e) {

}



return new ResponseEntity <>(sondageDateLieux, HttpStatus.OK);
}


@RequestMapping(method = RequestMethod.DELETE, value = "/sondageDateLieu/{idSondage}")
public ResponseEntity<SondageDateLieu> deleteReunion(@PathVariable("idSondage") Long idSondage) {
        
	SondageDateLieu sondageDateLieu = sondageDateLieuService.findOne(idSondage);
                    
		if (sondageDateLieu == null) {
                        
		return new ResponseEntity(new CustomErrorType("Impossible de supprimer les informations du travailleur"
                            + "ayant ce numéro" + idSondage + "qu'on ne trouve dans notre base de donnée."),
				HttpStatus.NOT_FOUND);
                    
                    }
		sondageDateLieuService.delete(idSondage);
            
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}




}
