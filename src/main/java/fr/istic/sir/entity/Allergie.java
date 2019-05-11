package fr.istic.sir.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "findAllAllergies", query = "SELECT a FROM Allergie a")})
public class Allergie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAllergie;
	private String libelleAllergie;
	private Collection<Participant> participants;
	
	@Id
	@GeneratedValue
	public Long getIdAllergie() {
		return idAllergie;
	}
	public void setIdAllergie(Long idAllergie) {
		this.idAllergie = idAllergie;
	}
	public String getLibelleAllergie() {
		return libelleAllergie;
	}
	public void setLibelleAllergie(String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	
	
	

}
