package rest_api.student;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rest_api.student.controller.Shoes;
import rest_api.student.controller.Student;

@SpringBootApplication
public class StudentApplication {

	 public ArrayList<Student> students = new ArrayList<>();
	 public ArrayList<Shoes> shoes = new ArrayList<>();

    
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	public StudentApplication(){
		students.add(new Student(1, "Fourwheel", 18, "Buddhism"));
		students.add(new Student(2, "Mark", 17, "Chirst"));
		students.add(new Student(3, "Biw", 19, "Buddhism"));
		shoes.add(new Shoes("Nike", 1, "red", 46));
		shoes.add(new Shoes("Lining", 2, "blue", 44));
		shoes.add(new Shoes("Adidas", 3, "red", 43));


	}

}
