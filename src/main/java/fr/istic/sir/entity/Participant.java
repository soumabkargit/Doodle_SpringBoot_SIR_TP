 package fr.istic.sir.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@DiscriminatorValue(value="Participant")
@NamedQueries({
    @NamedQuery(name = "findAllParticipants", query = "SELECT p FROM Participant p")})
public class Participant extends UserDoodle implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<SondageDate> sondageDate;
    private Collection<SondageLieu> sondageLieux;
    private Collection<SondageDateLieu> sondageDateLieux;
	
    private PreferenceAlimentaire preferenceAlimentaire;
    private Collection<Allergie> allergies;
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinTable(name ="Participant_SondageDate" , joinColumns=@JoinColumn(name="emailUtilisateur") , 
			inverseJoinColumns = @JoinColumn(name="idSondage"))
	public Collection<SondageDate> getSondageDate() {
		return sondageDate;
	}
	public void setSondageDate(Collection<SondageDate> sondageDate) {
		this.sondageDate = sondageDate;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinTable(name ="Participant_SondageLieu" , joinColumns=@JoinColumn(name="emailUtilisateur") , 
			inverseJoinColumns = @JoinColumn(name="idSondage"))
	public Collection<SondageLieu> getSondageLieux() {
		return sondageLieux;
	}
	public void setSondageLieux(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinTable(name ="Participant_SondageDateLieu" , joinColumns=@JoinColumn(name="emailUtilisateur") , 
			inverseJoinColumns = @JoinColumn(name="idSondage"))
	public Collection<SondageDateLieu> getSondageDateLieux() {
		return sondageDateLieux;
	}
	public void setSondageDateLieux(Collection<SondageDateLieu> sondageDateLieux) {
		this.sondageDateLieux = sondageDateLieux;
	}

	@ManyToOne
	//@JoinColumn(name)
	public PreferenceAlimentaire getPreferenceAlimentaire() {
		return preferenceAlimentaire;
	}
	public void setPreferenceAlimentaire(PreferenceAlimentaire preferenceAlimentaire) {
		this.preferenceAlimentaire = preferenceAlimentaire;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Participant_Allergie", joinColumns=@JoinColumn(name="emailUtilisateur"),
			   inverseJoinColumns=@JoinColumn(name="idAllergie"))
	public Collection<Allergie> getAllergies() {
		return allergies;
	}
	public void setAllergies(Collection<Allergie> allergies) {
		this.allergies = allergies;
	}
	


	
	
}
