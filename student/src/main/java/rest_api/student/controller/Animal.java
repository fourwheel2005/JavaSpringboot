package rest_api.student.controller;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal", schema = "public")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String type;
    public String color;

    @Column(nullable = true)
    public float weight;

    public Animal() {
    }

    public Animal(int id, String name, String type, String color, float gpa) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.weight = gpa;
    }
}
