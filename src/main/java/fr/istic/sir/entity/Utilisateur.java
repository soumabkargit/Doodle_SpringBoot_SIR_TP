package fr.istic.sir.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@DiscriminatorValue(value="Utilisateur")
@NamedQueries({
    @NamedQuery(name = "findAllUtilisateurs", query = "SELECT u FROM Utilisateur u")})
public class Utilisateur extends UserDoodle implements Serializable {

	private String motPasse;
    private Collection<SondageDate> sondageDates;
    private Collection<SondageLieu> sondageLieux;
    private Collection<SondageDateLieu> sondageDateLieux;

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

    

	@OneToMany(mappedBy="utilisateurSondageLieu",cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	public Collection<SondageLieu> getSondageLieux() {
		return sondageLieux;
	}

	public void setSondageLieu(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
	}	
	

	@OneToMany(mappedBy="utilisateurSondageDateLieu",cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	public Collection<SondageDateLieu> getSondageDateLieu() {
		return sondageDateLieux;
	}

	public void setondageDateLieu(Collection<SondageDateLieu> sondageDateLieu) {
		this.sondageDateLieux = sondageDateLieu;
	}


	@OneToMany(mappedBy="utilisateurSondageDate",cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	public Collection<SondageDate> getSondageDates() {
		return sondageDates;
	}

	public void setSondageDates(Collection<SondageDate> sondageDates) {
		this.sondageDates = sondageDates;
	}

	
	
	public void setSondageLieux(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
	}

	public void setSondageDateLieu(Collection<SondageDateLieu> sondageDateLieu) {
		this.sondageDateLieux = sondageDateLieu;
	}	
	
	
}
