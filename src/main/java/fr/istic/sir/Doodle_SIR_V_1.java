package fr.istic.sir;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.sir.entity.Allergie;
import fr.istic.sir.entity.Participant;
import fr.istic.sir.entity.PreferenceAlimentaire;
import fr.istic.sir.entity.Reunion;
import fr.istic.sir.entity.SondageDate;
import fr.istic.sir.entity.SondageDateLieu;
import fr.istic.sir.entity.SondageLieu;
import fr.istic.sir.entity.Utilisateur;
import fr.istic.sir.service.AllergieService;
import fr.istic.sir.service.ParticipantService;
import fr.istic.sir.service.PreferenceAlimentaireService;
import fr.istic.sir.service.ReunionService;
import fr.istic.sir.service.SondageDateLieuService;
import fr.istic.sir.service.SondageDateService;
import fr.istic.sir.service.SondageLieuService;
import fr.istic.sir.service.UtilisateurService;



@Transactional
@Service
@SpringBootApplication
public class Doodle_SIR_V_1 {

	public static void main(String[] args) {
		SpringApplication.run(Doodle_SIR_V_1.class, args);
		
	}
	
	@Bean
    CommandLineRunner 
    run(UtilisateurService serviceUtilisateurDaoImpl, ParticipantService serviceParticipantDaoImpl,
    		ReunionService serviceReunionDaoImpl, SondageLieuService serviceSondageLieuDaoImpl,
    		SondageDateLieuService serviceSondageDateLieuDaoImpl, SondageDateService serviceSondageDateDaoImpl,
    		PreferenceAlimentaireService servicePreferenceAlimentaireDaoImpl, AllergieService serviceAllergieDaoImpl) {
        return args -> {
        	 Collection <Participant> participantsSondageDateLieu;
        	 Collection <Participant> participantsSondageLieu;
        	 Collection <Participant> participantsSondageDate;
        	 
        	 
        	 Utilisateur utilisateurDateLieu = new Utilisateur();
     		utilisateurDateLieu.setEmailUtilisateur("soumabkar@gmail.com");
     		utilisateurDateLieu.setNom("SOUMAHORO");
     		utilisateurDateLieu.setPrenom("Abdoul-Karim");
     		utilisateurDateLieu.setMotPasse("soumabkar");
     		serviceUtilisateurDaoImpl.save(utilisateurDateLieu);
     			
     	 
     			Utilisateur utilisateurDate = new Utilisateur();
     			utilisateurDate.setEmailUtilisateur("anohabbah@gmail.com");
     			utilisateurDate.setNom("ABBAH");
     			utilisateurDate.setPrenom("ANOH");
     			utilisateurDate.setMotPasse("Elephants");
     			serviceUtilisateurDaoImpl.save(utilisateurDate);
     			
     			Utilisateur utilisateurLieu = new Utilisateur();
     			utilisateurLieu.setEmailUtilisateur("maudmcok@gmail.com");
     			utilisateurLieu.setNom("MAUD");
     			utilisateurLieu.setPrenom("Charles-Olivier");
     			utilisateurLieu.setMotPasse("maudmcok");
     			serviceUtilisateurDaoImpl.save(utilisateurLieu);
        	 
        	
     		Reunion reunion0 = new Reunion();
     		reunion0.setIntitule("Revision sir");
     		reunion0.setResume("Preparation de l'examen de sir");
     		serviceReunionDaoImpl.save(reunion0);;
     		
     		Reunion reunion1 = new Reunion();
     		reunion1.setIntitule("Soiree chez Abbah");
     		reunion1.setResume("Rencontre en pote, partie de code puis faire le show");
     		serviceReunionDaoImpl.save(reunion1);
     		
     		Reunion reunion2 = new Reunion();
     		reunion2.setIntitule("Soiree chez Chris");
     		reunion2.setResume("Rencontre en pote, preparation des examens, organisations de projets ...");
     		serviceReunionDaoImpl.save(reunion2);
     		
     		
    		SondageLieu sondageLieu0 = new SondageLieu();
    		sondageLieu0.setReunion(reunion0);
    		sondageLieu0.setLieuSondage("Rennes");
    		//sondageLieu0.setParticipants(participantsSondageLieu);
    		sondageLieu0.setPauseDejeunerSondage(true);
    		sondageLieu0.setUtilisateurSondageLieu(utilisateurLieu);
    		serviceSondageLieuDaoImpl.save(sondageLieu0);
    		
    		
    		SondageLieu sondageLieu1 = new SondageLieu();
    		sondageLieu1.setReunion(reunion1);
    		sondageLieu1.setLieuSondage("Monpelier");
    		//sondageLieu2.setParticipants(participantsSondageDate);
    		sondageLieu1.setPauseDejeunerSondage(true);
    		sondageLieu1.setUtilisateurSondageLieu(utilisateurDate);
    		serviceSondageLieuDaoImpl.save(sondageLieu1);

    		SondageLieu sondageLieu3 = new SondageLieu();
    		sondageLieu3.setReunion(reunion2);
    		sondageLieu3.setLieuSondage("Seguela");
    		//sondageLieu3.setParticipants(participantsSondageLieu);
    		sondageLieu3.setPauseDejeunerSondage(false);
    		sondageLieu3.setUtilisateurSondageLieu(utilisateurDateLieu);
    		serviceSondageLieuDaoImpl.save(sondageLieu3);
    		
    		SondageDateLieu sondageDateLieu0 = new SondageDateLieu();
    		sondageDateLieu0.setReunion(reunion1);
    		sondageDateLieu0.setLieuSondageDateLieu("Paris"); 
    		Date date0 = null;
    	    SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("dd/MM/yyyy");
    	    String date01 = "01/04/2019";
    	    date0 = simpleDateFormat0.parse(date01);
    		sondageDateLieu0.setDateSondageDateLieu(date0);
    		//sondageDateLieu0.setParticipants(participantsSondageLieu);
    		sondageDateLieu0.setPauseDejeunerSondage(true);
    		sondageDateLieu0.setUtilisateurSondageDateLieu(utilisateurDateLieu);
    		serviceSondageDateLieuDaoImpl.save(sondageDateLieu0);
    		
    		SondageDateLieu sondageDateLieu1 = new SondageDateLieu();
    		sondageDateLieu1.setReunion(reunion2);
    		sondageDateLieu1.setLieuSondageDateLieu("Abidjan"); 
    		Date date1 = null;
    	    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
    	    String date11 = "02/04/2019";
    	    date1 = simpleDateFormat1.parse(date11);
    		sondageDateLieu1.setDateSondageDateLieu(date1);
    		//sondageDateLieu0.setParticipants(participantsSondageLieu);
    		sondageDateLieu1.setPauseDejeunerSondage(true);
    		sondageDateLieu1.setUtilisateurSondageDateLieu(utilisateurDate);
    		serviceSondageDateLieuDaoImpl.save(sondageDateLieu1);
    		
    		
    		SondageDateLieu sondageDateLieu2 = new SondageDateLieu();
    		sondageDateLieu2.setReunion(reunion0);
    		sondageDateLieu2.setLieuSondageDateLieu("Dakar"); 
    		Date date2 = null;
    	    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
    	    String date21 = "03/04/2019";
    	    date2 = simpleDateFormat2.parse(date21);
    		sondageDateLieu2.setDateSondageDateLieu(date2);
    		//sondageDateLieu0.setParticipants(participantsSondageLieu);
    		sondageDateLieu2.setPauseDejeunerSondage(false);
    		sondageDateLieu2.setUtilisateurSondageDateLieu(utilisateurLieu);
    		serviceSondageDateLieuDaoImpl.save(sondageDateLieu2);
    		
    		
    		SondageDate sondageDate0 = new SondageDate();
    		sondageDate0.setReunion(reunion2);
    		Date date3 = null;
    	    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
    	    String date31 = "04/04/2019";
    	    date3 = simpleDateFormat3.parse(date31);
    	    sondageDate0.setDateSondage(date3);
    		//sondageDate0.setParticipants(participantsSondageLieu);
    		sondageDate0.setPauseDejeunerSondage(true);
    		sondageDate0.setUtilisateurSondageDate(utilisateurLieu);
    		serviceSondageDateDaoImpl.save(sondageDate0);
    		
    		
    		SondageDate sondageDate1 = new SondageDate();
    		sondageDate1.setReunion(reunion0);
    		Date date4 = null;
    	    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("dd/MM/yyyy");
    	    String date32 = "05/04/2019";
    	    date4 = simpleDateFormat4.parse(date32);
    	    sondageDate1.setDateSondage(date4);
    		//sondageDate0.setParticipants(participantsSondageLieu);
    	    sondageDate1.setPauseDejeunerSondage(true);
    	    sondageDate1.setUtilisateurSondageDate(utilisateurDateLieu);
    		serviceSondageDateDaoImpl.save(sondageDate1);
    		
    		
    		SondageDate sondageDate2 = new SondageDate();
    		sondageDate2.setReunion(reunion1);
    		Date date5 = null;
    	    SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("dd/MM/yyyy");
    	    String date33 = "06/04/2019";
    	    date5 = simpleDateFormat5.parse(date33);
    	    sondageDate2.setDateSondage(date5);
    		//sondageDate0.setParticipants(participantsSondageLieu);
    		sondageDate2.setPauseDejeunerSondage(false);
    		sondageDate2.setUtilisateurSondageDate(utilisateurDate);
    		serviceSondageDateDaoImpl.save(sondageDate2);
    		
    		Allergie allergie0 = new Allergie();
    		allergie0.setLibelleAllergie("allergie 0");
    		//allergie0.setParticipants(participantsSondageDate);
    		serviceAllergieDaoImpl.save(allergie0);
    		
    		Allergie allergie1 = new Allergie();
    		allergie1.setLibelleAllergie("allergie 1");
    		//allergie1.setParticipants(participantsSondageLieu);
    		serviceAllergieDaoImpl.save(allergie1);
    		
    		Allergie allergie2 = new Allergie();
    		allergie2.setLibelleAllergie("allergie 2");
    	//	allergie2.setParticipants(participantsSondageDateLieu);
    		serviceAllergieDaoImpl.save(allergie2);	
    		
    		PreferenceAlimentaire preferenceAlimentaire0 = new PreferenceAlimentaire();
    		preferenceAlimentaire0.setLibellePreferenceAlimentaire("preference 0");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire0);
    		
    		PreferenceAlimentaire preferenceAlimentaire1 = new PreferenceAlimentaire();
    		preferenceAlimentaire1.setLibellePreferenceAlimentaire("preference 1");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire1);
    		
    		PreferenceAlimentaire preferenceAlimentaire2 = new PreferenceAlimentaire();
    		preferenceAlimentaire2.setLibellePreferenceAlimentaire("preference 2");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire2);
    		
    		PreferenceAlimentaire preferenceAlimentaire3 = new PreferenceAlimentaire();
    		preferenceAlimentaire3.setLibellePreferenceAlimentaire("preference 3");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire3);
    		
    		PreferenceAlimentaire preferenceAlimentaire4 = new PreferenceAlimentaire();
    		preferenceAlimentaire4.setLibellePreferenceAlimentaire("preference 4");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire4);
    		
    		PreferenceAlimentaire preferenceAlimentaire5 = new PreferenceAlimentaire();
    		preferenceAlimentaire5.setLibellePreferenceAlimentaire("preference 5");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire5);
    		
    		PreferenceAlimentaire preferenceAlimentaire6 = new PreferenceAlimentaire();
    		preferenceAlimentaire6.setLibellePreferenceAlimentaire("preference 6");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire6);
    		
    		PreferenceAlimentaire preferenceAlimentaire7 = new PreferenceAlimentaire();
    		preferenceAlimentaire7.setLibellePreferenceAlimentaire("preference 7");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire7);
    		
    		PreferenceAlimentaire preferenceAlimentaire8 = new PreferenceAlimentaire();
    		preferenceAlimentaire8.setLibellePreferenceAlimentaire("preference 8");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire8);
    		
    		PreferenceAlimentaire preferenceAlimentaire9 = new PreferenceAlimentaire();
    		preferenceAlimentaire9.setLibellePreferenceAlimentaire("preference 9");
    		servicePreferenceAlimentaireDaoImpl.save(preferenceAlimentaire9);
    		
    		Allergie a0 = new Allergie();
    		Allergie a1 = new Allergie();
    		Allergie a2 = new Allergie();
    		
    		a0=serviceAllergieDaoImpl.findOne((long) 1);
    		a1=serviceAllergieDaoImpl.findOne((long) 2);
    		a2=serviceAllergieDaoImpl.findOne((long) 3);
    		
    		Collection<Allergie> allergies0 = new ArrayList<Allergie>();
    		Collection<Allergie> allergies1 = new ArrayList<Allergie>();
    		Collection<Allergie> allergies2 = new ArrayList<Allergie>();
    		
    		Collection<Allergie> allergies3 = new ArrayList<Allergie>();
    		Collection<Allergie> allergies4 = new ArrayList<Allergie>();
    		Collection<Allergie> allergies5 = new ArrayList<Allergie>();
    		
    		Collection<Allergie> allergies6 = new ArrayList<Allergie>();
    		
    		allergies0.add(a0);
    		allergies1.add(a1);
    		allergies2.add(a2);
    		
    		allergies3.add(a0);
    		allergies3.add(a1);
    		allergies4.add(a0);
    		allergies4.add(a2);
    		allergies5.add(a1);
    		allergies5.add(a2);
    		
    		allergies6.add(a0);
    		allergies6.add(a1);
    		allergies6.add(a2);
    		
    		SondageDate s00 = new SondageDate();
    		SondageDate s01 = new SondageDate();
    		SondageDate s02 = new SondageDate();
    		
    		s00=serviceSondageDateDaoImpl.findOne((long) 7);
    		s01=serviceSondageDateDaoImpl.findOne((long) 8);
    		s02=serviceSondageDateDaoImpl.findOne((long) 9);
    		
    		Collection<SondageDate> sondageDates0 = new ArrayList<SondageDate>();
    		Collection<SondageDate> sondageDates1 = new ArrayList<SondageDate>();
    		Collection<SondageDate> sondageDates2 = new ArrayList<SondageDate>();
    		
    		Collection<SondageDate> sondageDates3 = new ArrayList<SondageDate>();
    		Collection<SondageDate> sondageDates4 = new ArrayList<SondageDate>();
    		Collection<SondageDate> sondageDates5 = new ArrayList<SondageDate>();
    		
    		Collection<SondageDate> sondageDates6 = new ArrayList<SondageDate>();
    		
    		sondageDates0.add(s00);
    		sondageDates1.add(s01);
    		sondageDates2.add(s02);
    		
    		sondageDates3.add(s00);
    		sondageDates3.add(s01);
    		sondageDates4.add(s01);
    		sondageDates4.add(s02);
    		sondageDates5.add(s00);
    		sondageDates5.add(s02);
    		
    		sondageDates6.add(s00);
    		sondageDates6.add(s01);
    		sondageDates6.add(s02);
    		
    		SondageDateLieu s10 = new SondageDateLieu();
    		SondageDateLieu s11 = new SondageDateLieu();
    		SondageDateLieu s12 = new SondageDateLieu();
    		
    		
    		Collection<SondageDateLieu> sondageDateLieux0 = new ArrayList<SondageDateLieu>();
    		Collection<SondageDateLieu> sondageDateLieux1 = new ArrayList<SondageDateLieu>();
    		Collection<SondageDateLieu> sondageDateLieux2 = new ArrayList<SondageDateLieu>();
    		
    		Collection<SondageDateLieu> sondageDateLieux3 = new ArrayList<SondageDateLieu>();
    		Collection<SondageDateLieu> sondageDateLieux4 = new ArrayList<SondageDateLieu>();
    		Collection<SondageDateLieu> sondageDateLieux5 = new ArrayList<SondageDateLieu>();
    		
    		Collection<SondageDateLieu> sondageDateLieux6 = new ArrayList<SondageDateLieu>();
    		
    		sondageDateLieux2.add(s10);
    		sondageDateLieux1.add(s11);
    		sondageDateLieux0.add(s12);
    		
    		sondageDateLieux5.add(s10);
    		sondageDateLieux5.add(s11);
    		sondageDateLieux4.add(s11);
    		sondageDateLieux4.add(s12);
    		sondageDateLieux3.add(s10);
    		sondageDateLieux3.add(s12);
    		
    		sondageDateLieux6.add(s10);
    		sondageDateLieux6.add(s11);
    		sondageDateLieux6.add(s12);
    		
    		SondageLieu s20 = new SondageLieu();
    		SondageLieu s21 = new SondageLieu();
    		SondageLieu s22 = new SondageLieu();
    		
    		Collection<SondageLieu> sondageLieux0 = new ArrayList<SondageLieu>();
    		Collection<SondageLieu> sondageLieux1 = new ArrayList<SondageLieu>();
    		Collection<SondageLieu> sondageLieux2 = new ArrayList<SondageLieu>();
    		
    		Collection<SondageLieu> sondageLieux3 = new ArrayList<SondageLieu>();
    		Collection<SondageLieu> sondageLieux4 = new ArrayList<SondageLieu>();
    		Collection<SondageLieu> sondageLieux5 = new ArrayList<SondageLieu>();
    		
    		Collection<SondageLieu> sondageLieux6 = new ArrayList<SondageLieu>();
    		
    		sondageLieux1.add(s20);
    		sondageLieux0.add(s21);
    		sondageLieux2.add(s22);
    		
    		sondageLieux4.add(s20);
    		sondageLieux4.add(s21);
    		sondageLieux5.add(s21);
    		sondageLieux5.add(s22);
    		sondageLieux3.add(s20);
    		sondageLieux3.add(s22);
    		
    		sondageLieux6.add(s20);
    		sondageLieux6.add(s21);
    		sondageLieux6.add(s22);

    		Participant participantDateLieu = new Participant();
    		participantDateLieu.setEmailUtilisateur("mtouganroland@gmail.com");
    		participantDateLieu.setNom("TOUGAN");
    		participantDateLieu.setPrenom("Roland");
    		participantDateLieu.setAllergies(allergies0);
    		participantDateLieu.setPreferenceAlimentaire(preferenceAlimentaire0);
    		participantDateLieu.setSondageDateLieux(sondageDateLieux6);
    		serviceParticipantDaoImpl.save(participantDateLieu);
    		
    		Participant participantDate = new Participant();
    		participantDate.setEmailUtilisateur("_mtouganroland@gmail.com");
    		participantDate.setNom("TOUGAN");
    		participantDate.setPrenom("Roland");
    		participantDate.setAllergies(allergies1);
    		participantDate.setPreferenceAlimentaire(preferenceAlimentaire1);
    		participantDate.setSondageDate(sondageDates6);
    		serviceParticipantDaoImpl.save(participantDate);
    		
    		Participant participantLieu = new Participant();
    		participantLieu.setEmailUtilisateur("__mtouganroland@gmail.com");
    		participantLieu.setNom("TOUGAN");
    		participantLieu.setPrenom("Roland");
    		participantLieu.setPreferenceAlimentaire(preferenceAlimentaire2);
    		participantLieu.setAllergies(allergies2);
    		participantLieu.setSondageLieux(sondageLieux6);
    		serviceParticipantDaoImpl.save(participantLieu);
    		
    		for (int i = 0; i <= 99; i++) {
    			Participant participant = new Participant();
    			participant.setEmailUtilisateur(i+"participant@gmail.com");
    			participant.setNom("nom_"+i);
    			participant.setPrenom("prenom_"+i);
    			
    			if (i<=9) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire0);
    				participant.setAllergies(allergies0);
    				participant.setSondageDate(sondageDates0);
    				participant.setSondageLieux(sondageLieux6);
    				participant.setSondageDateLieux(sondageDateLieux5);
    			}else if (10>=i || i<=19) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire1);
    				participant.setAllergies(allergies1);
    				participant.setSondageDate(sondageDates1);
    				participant.setSondageLieux(sondageLieux5);
    				participant.setSondageDateLieux(sondageDateLieux4);
    			}else if (20>=i || i<=29) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire2);
    				participant.setAllergies(allergies2);
    				participant.setSondageDate(sondageDates2);
    				participant.setSondageLieux(sondageLieux4);
    				participant.setSondageDateLieux(sondageDateLieux3);
    			}
    			else if (30>=i || i<=39) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire3);
    				participant.setAllergies(allergies3);
    				participant.setSondageDate(sondageDates3);
    				participant.setSondageLieux(sondageLieux2);
    				participant.setSondageDateLieux(sondageDateLieux6);
    			}
    			else if (40>=i || i<=49) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire4);
    				participant.setAllergies(allergies4);
    				participant.setSondageDate(sondageDates4);
    				participant.setSondageLieux(sondageLieux3);
    				participant.setSondageDateLieux(sondageDateLieux2);
    			}
    			else if (50>=i || i<=59) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire5);
    				participant.setAllergies(allergies5);
    				participant.setSondageDate(sondageDates5);
    				participant.setSondageLieux(sondageLieux1);
    				participant.setSondageDateLieux(sondageDateLieux0);
    			}
    			else if (60>=i || i<=69) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire6);
    				participant.setAllergies(allergies6);
    				participant.setSondageDate(sondageDates6);
    				participant.setSondageLieux(sondageLieux0);
    				participant.setSondageDateLieux(sondageDateLieux1);
    			}
    			else if (70>=i || i<=79) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire7);
    				participant.setAllergies(allergies0);			
    				participant.setSondageLieux(sondageLieux6);
    			}
    			else if (80>=i || i<=89) {
    				participant.setPreferenceAlimentaire(preferenceAlimentaire8);
    				participant.setAllergies(allergies1);
    				participant.setSondageDate(sondageDates6);
    			}
    			else 
    			{
    				participant.setPreferenceAlimentaire(preferenceAlimentaire9);
    				participant.setAllergies(allergies2);
    				participant.setSondageDateLieux(sondageDateLieux6);
    			}
    			
    			serviceParticipantDaoImpl.save(participant);


        	 
            };
            
        };

}
}
