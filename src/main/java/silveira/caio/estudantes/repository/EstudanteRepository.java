package silveira.caio.estudantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.estudantes.entity.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
