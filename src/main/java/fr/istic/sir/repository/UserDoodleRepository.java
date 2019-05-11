package fr.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.istic.sir.entity.UserDoodle;


public interface UserDoodleRepository extends JpaRepository<UserDoodle, String> {

}
