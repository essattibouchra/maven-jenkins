package suptech.casa.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import suptech.casa.entities.Groupe;
import suptech.casa.entities.Student;
import suptech.casa.repositories.GroupeRepository;
import suptech.casa.repositories.StudentRepository;
import suptech.casa.services.groupeServices;


            @RestController
         public class GroupeController {
   
            	@Autowired
            groupeServices gs;
            	
            	@GetMapping("groupe")
            	public  List<Groupe> getAllGoupes()	{
            		return gs.getAllGoupes();
            	}
            	
            	
            	@PostMapping ("groupe")
            	public Groupe addGroupe(@RequestBody Groupe g) {
            	
            		return gs.addGroupe(g);
            	
            	}
            	
            	@GetMapping ("groupe/{id}")
            	public 	 Groupe getGroupeById (@PathVariable Long id) {
           		 return gs.getGroupeById(id);
            	}
            	
            	@GetMapping ("groupe/{id}/student")
            	public 	 List<Student> getStudentByGroupeId (@PathVariable Long id) 
            	{
            		
            		return gs.getStudentByGroupeId(id);


			    }
            	
            	
            	@PostMapping ("groupe/{id}/student")
            	public 	 Student  addStudentToGroupe (@PathVariable Long id,@RequestBody Student student) {
            	
					return gs.addStudentToGroupe(id, student);
					}
            	
            	
            	
            	
//            	@DeleteMapping("groupe/{id}")
//            	public void deleteGroupe (@PathVariable Long id) {
//            	gr.deleteById(id);
 //            	
//            }	
//            
            	
            	
            	@DeleteMapping("groupe/{id}")
            	public void deleteGroupe ( Long id) {
            		
            	
            	gs.DeleteGroupe(id)  ;

            
                 }
            	}



