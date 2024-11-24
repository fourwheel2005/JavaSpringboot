package rest_api.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rest_api.student.repository.AnimalRepository;
import rest_api.student.repository.ShoesRepository;
import rest_api.student.repository.StudentRepository;

@RestController
public class studentController {
    @Autowired
    private StudentRepository repo;
    @Autowired
    private ShoesRepository reposhoes;
    @Autowired
    private AnimalRepository repoanimal;

   
   
//    @GetMapping("/")
//    public String getStudent(){
//     return "Hello";
//    }
@GetMapping("/student")
public ResponseEntity<List<Student>>Allstudent(){
    List<Student> student = repo.findAll();
    return new ResponseEntity<>(student,HttpStatus.OK);
}
@GetMapping("/student/{id}")
public ResponseEntity<Student> studentId(@PathVariable long id){
    Optional<Student> student  = repo.findById(id);
    if(student.isPresent()){
        return new ResponseEntity<>(student.get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@GetMapping("/shoes")
public ResponseEntity<List<Shoes>>AllShoes(){
    List<Shoes> shoes = reposhoes.findAll();
    
        return new ResponseEntity<>(shoes,HttpStatus.OK);   
}
@GetMapping("/shoes/{id}")
public ResponseEntity<Shoes> IdShoes(@PathVariable long id){
    Optional<Shoes> shoes  = reposhoes.findById(id);
    if(shoes.isPresent()){
       return new ResponseEntity<>(shoes.get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@PostMapping("/student")
public ResponseEntity<Student> addStudent(@RequestBody Student student){
    try{
        Student newStudent = repo.save(student);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }
    catch(Exception e){
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
@PostMapping("/shoes")
public ResponseEntity<Shoes> addShoes(@RequestBody Shoes shoes){
    try{
        Shoes newShoes = reposhoes.save(shoes);
        return new ResponseEntity<>(newShoes,HttpStatus.CREATED);
    }
    catch(Exception e){
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
@PutMapping("/shoes/{id}")
    public ResponseEntity<Shoes> updateShoes(@PathVariable long id, @RequestBody Shoes newShoes) {
        Optional<Shoes> foundShoes = reposhoes.findById(id);

        if (foundShoes.isPresent()) {
            Shoes shoes = foundShoes.get();
            shoes.name = newShoes.name;
            shoes.color = newShoes.color;
            shoes.size = newShoes.size;
          
            Shoes updatedShoes = reposhoes.save(shoes);
            return new ResponseEntity<>(updatedShoes, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/animal/{id}")
        public ResponseEntity<Animal> updateAnimal(@PathVariable long id, @RequestBody Animal newAnimal) {
            Optional<Animal> foundAnimal = repoanimal.findById(id);
    
            if (foundAnimal.isPresent()) {
                Animal animal = foundAnimal.get();
                animal.name = newAnimal.name;
                animal.type = newAnimal.type;
                animal.color = newAnimal.color;
                animal.weight = newAnimal.weight;
                
                Animal updatedAnimal = repoanimal.save(animal);
                return new ResponseEntity<>(updatedAnimal, HttpStatus.OK);
            }
    
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

            @DeleteMapping("/shoes/{id}")
    public ResponseEntity<HttpStatus> deleteShoes(@PathVariable long id) {
        try {
            reposhoes.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}



