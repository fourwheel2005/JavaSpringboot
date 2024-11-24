package rest_api.student.controller;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String color;
    public int size;
    public Shoes(){
        
    }
    public Shoes(String name,long id,String color,int size){
        this.name=name;
        this.id=id;
        this.color=color;
        this.size=size;
    }    
}
