package fr.istic.sir.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@DiscriminatorValue(value="SondageDateLieu")
@NamedQueries({
    @NamedQuery(name = "findAllSondageDateLieux", query = "SELECT s FROM SondageDateLieu s")})
public class SondageDateLieu extends Sondage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date dateSondageDateLieu;
	private String lieuSondageDateLieu;
	private Collection <Participant> participants;
	private Utilisateur utilisateurSondageDateLieu;
	
	
	public Date getDateSondageDateLieu() {
		return dateSondageDateLieu;
	}
	public void setDateSondageDateLieu(Date dateSondageDateLieu) {
		this.dateSondageDateLieu = dateSondageDateLieu;
	}
	
	public String getLieuSondageDateLieu() {
		return lieuSondageDateLieu;
	}
	public void setLieuSondageDateLieu(String lieuSondageDateLieu) {
		this.lieuSondageDateLieu = lieuSondageDateLieu;
	}
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	public Collection<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) {
		this.participants = participants;
	}
	
	@ManyToOne
	public Utilisateur getUtilisateurSondageDateLieu() {
		return utilisateurSondageDateLieu;
	}
	public void setUtilisateurSondageDateLieu(Utilisateur utilisateurSondageDateLieu) {
		this.utilisateurSondageDateLieu = utilisateurSondageDateLieu;
	}
	
}
