package suptech.casa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import suptech.casa.entities.Student;
import suptech.casa.repositories.StudentRepository;

@Service
public class StudentServices {
	List<Student> students=new ArrayList<>();
	
	@Autowired
	StudentRepository sr;
	
	
	public  List<Student> getAllstudents(){
		
		return sr.findAll();
	}
	
	
	public Student addStudent( Student s) {
		
		return sr.save(s);
		
	}
	
	
	  
	 public void deleteStudent ( Long id) {
		sr.deleteById(id);
	    	 
	     }
	
	 
    public void deleteStudent (	 Student s) {
	this.students.remove(s);
	}	
	
	
	
	public Student updateStudent ( Student s) {
	return sr.save(s);
	}
	
	
	public  List<Student> getAllstudents(int page, int size ,String field){ 
		
		Pageable pg= PageRequest.of(page, size, Sort.by(field));
		    Page<Student> StudentsPage= sr.findAll(pg);
		    return StudentsPage.getContent();
		    
	}
}




