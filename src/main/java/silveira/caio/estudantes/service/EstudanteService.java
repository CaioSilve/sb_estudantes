package silveira.caio.estudantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.estudantes.entity.Estudante;
import silveira.caio.estudantes.repository.EstudanteRepository;

@Service
public class EstudanteService {

	@Autowired
	EstudanteRepository repo;
	
	public List<Estudante> getAllEstudantes(){
		return repo.findAll();
	}
	
	public Estudante saveEstudante(Estudante estu) {
		return repo.save(estu);
	}
	
	public Estudante updateEstudante(Estudante estu) {
		return repo.save(estu);
	}
	
	public Estudante getEstudanteById(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteEstudanteById(Long id) {
		repo.deleteById(id);
	}
}
