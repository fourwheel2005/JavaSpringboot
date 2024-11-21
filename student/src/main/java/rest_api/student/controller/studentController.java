package rest_api.student.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rest_api.student.StudentApplication;

@RestController
public class studentController {

    private StudentApplication app;
    public studentController(StudentApplication app){
        this.app=app;
    }
   
//    @GetMapping("/")
//    public String getStudent(){
//     return "Hello";
//    }
@GetMapping("/student")
public ResponseEntity<ArrayList<Student>>Allstudent(){
    return new ResponseEntity<>(app.students,HttpStatus.OK);
}
@GetMapping("/shoes")
public ResponseEntity<ArrayList<Shoes>>AllShoes(){
    return new ResponseEntity<>(app.shoes,HttpStatus.ACCEPTED);
}
@GetMapping("/shoes-name")
public ResponseEntity<ArrayList<String>>ShoesName(){
    ArrayList<String> nameShoes = new ArrayList<>();
    for (int i = 0; i < app.shoes.size(); i++) {
        nameShoes.add(app.shoes.get(i).name);

    }
    return new ResponseEntity<>(nameShoes,HttpStatus.ALREADY_REPORTED);
}



    
}
