package ma.emsi.tp_jpa;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*patientRepository.save(new Patient(null,"hassan",new Date(),2300,false));
		patientRepository.save(new Patient(null,"Farah",new Date(),200,false));
		patientRepository.save(new Patient(null,"Imane",new Date(),4300,false));
		patientRepository.save(new Patient(null,"Ayman",new Date(),2500,false));
		patientRepository.save(new Patient(null,"yassine",new Date(),300,true));*/
	}

}
