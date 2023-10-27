package suptech.casa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import suptech.casa.entities.Groupe;
import suptech.casa.entities.Student;


@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByGroupe (Groupe g) ;

	
}
