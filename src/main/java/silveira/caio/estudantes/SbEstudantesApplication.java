package silveira.caio.estudantes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import silveira.caio.estudantes.entity.Estudante;
import silveira.caio.estudantes.repository.EstudanteRepository;

@SpringBootApplication
public class SbEstudantesApplication implements CommandLineRunner{

	@Autowired
	EstudanteRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SbEstudantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudante e1 = new Estudante("Caio", "cac@", "16995658", "Avenida 4");
		Estudante e2 = new Estudante("Roberta", "robs@", "1696655", "Rua 4");
		Estudante e3 = new Estudante("Flávio", "cac@", "16997485", "Avenida W");
		
		repo.saveAll(Arrays.asList(e1,e2,e3));
		
	}

}
