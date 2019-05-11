package fr.istic.sir.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;




@Entity

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminatorSondage",
discriminatorType=DiscriminatorType.STRING)
public abstract class Sondage  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idSondage;
	private Reunion reunion;
	private boolean pauseDejeunerSondage;
	
	@Id
	@GeneratedValue
	public Long getIdSondage() {
		return idSondage;
	}
	public void setIdSondage(Long idSondage) {
		this.idSondage = idSondage;
	}

	@ManyToOne
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	public boolean isPauseDejeunerSondage() {
		return pauseDejeunerSondage;
	}
	public void setPauseDejeunerSondage(boolean pauseDejeunerSondage) {
		this.pauseDejeunerSondage = pauseDejeunerSondage;
	}

	

}
