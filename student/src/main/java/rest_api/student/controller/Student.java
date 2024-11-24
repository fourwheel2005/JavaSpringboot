package rest_api.student.controller;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public int age;
    public String Religion;
    
    public Student(){
        
    }
    public Student (long id,String name,int age,String Religion){
        this.id=id;
        this.name=name;
        this.age=age;
        this.Religion=Religion;
}

}
