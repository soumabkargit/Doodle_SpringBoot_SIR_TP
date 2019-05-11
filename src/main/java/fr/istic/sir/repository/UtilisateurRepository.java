package fr.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istic.sir.entity.Utilisateur;



public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

}
