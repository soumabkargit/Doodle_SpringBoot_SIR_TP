package fr.istic.sir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service
@SpringBootApplication
public class Doodle_SIR_V_1 {

	public static void main(String[] args) {
		SpringApplication.run(Doodle_SIR_V_1.class, args);
		
	}

}
