package fr.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istic.sir.entity.Sondage;


public interface SondageRepository extends JpaRepository<Sondage, Long> {

}
