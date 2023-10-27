package suptech.casa.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import suptech.casa.entities.Student;
import suptech.casa.repositories.StudentRepository;
import suptech.casa.services.StudentServices;

@CrossOrigin(origins = "*")
@RestController

public class Studentcontroller  {
	
	

	List<Student> students=new ArrayList<>();
	
	@Autowired
	StudentServices ss;
	
	@GetMapping("student")
	public  List<Student> getAllstudents(){
	return ss.getAllstudents();
	}
	
	@PostMapping ("student")
	public Student addStudent(
			@RequestParam Long id,
	         @RequestParam String nom,
	         @RequestParam int age,
	         @RequestParam  MultipartFile file) throws IllegalStateException,IOException{
		System.out.println(file);
	         System.out.println(file.toString());
	         String currentPath=System.getProperty("user.dir");
	         System.out.println("currentPath : "+currentPath);

	         file.transferTo(new File(currentPath+"\\src\\main\\resources\\static\\photos\\"+id+".jpg"));;
	         Student s= new Student();
	         s.setId(id);
	         s.setNom(nom);
	         s.setAge(age);
	        s.setImage("http://localhost:8080/photos/"+id+".jpg");
	         return ss.addStudent(s);
	}
	
	
	@DeleteMapping ("/student/{id}")  
	 public void deleteStudent (@PathVariable(name="id") Long id) {
		ss.deleteStudent(id);
	    	 
	     }
	
	@DeleteMapping ("student")  
    public void deleteStudent (@RequestBody Student s) {
//		s.setId(2);
	this.students.remove(s);
	}	
	
	
	@PutMapping ("student" )
	public Student updateStudent (@RequestBody Student s) {
	return ss.updateStudent(s);
	}
	
	@GetMapping ("student/{page}/{size}/{field}")
	public List<Student> getAllStudents (@PathVariable  int page ,  @PathVariable int  size, @PathVariable  String field){
		
		 return ss.getAllstudents(page, size, field );
		
		
	}
	
	
}

