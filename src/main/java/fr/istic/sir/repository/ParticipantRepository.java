package fr.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istic.sir.entity.Participant;



public interface ParticipantRepository extends JpaRepository<Participant, String> {

}
