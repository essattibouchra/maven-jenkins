package suptech.casa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import suptech.casa.entities.Groupe;
import suptech.casa.entities.Student;
import suptech.casa.repositories.GroupeRepository;
import suptech.casa.repositories.StudentRepository;

@Service
public class groupeServices {
	
	@Autowired
	GroupeRepository gr;
	
	
	
 	@Autowired
	StudentRepository sr ;
	
	
	public  List<Groupe> getAllGoupes()	{
		return gr.findAll();
	}
	
	
	
	public Groupe addGroupe( Groupe g) {
	
		return gr.save(g);
	
	}
	
	
	public 	 Groupe getGroupeById ( Long id) {
		 return gr.findById(id).get();
	}
	
	
	public 	 List<Student> getStudentByGroupeId ( Long id) 
	{
		Groupe g= gr.findById(id).get();
		return sr.findByGroupe(g);


    }
	
	
	
	public 	 Student  addStudentToGroupe ( Long id, Student student) {
		System.out.println("Saving student in the groupe ");
		System.out.println("student info name "+student.getNom());
		System.out.println("student info age "+student.getAge());
		student.setGroupe(gr.findById(id).get());
		sr.save(student);
		return sr.save(student);
		}
	
	
	
      public  void DeleteGroupe(Long id) {
    	  
    	  
    	  List<Student> students= getStudentByGroupeId(id);
      	students. forEach (s->{
      	s. setGroupe (null) ;
      	}) ;
      	gr.deleteById (id) ;
      }
 
}
