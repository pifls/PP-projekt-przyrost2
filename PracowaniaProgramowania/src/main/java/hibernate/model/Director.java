package hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DIRECTOR")
public class Director {


    @Id
    @GeneratedValue
    @Column(name = "dir_id")
    private int dir_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age") 
    private int age;

    @Column(name = "nationality")
    private String nationality;

    public Director() {
    }

    // Getters //

    public int getDir_id() {
        return dir_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    // Setters //


    public void setDir_id(int dir_id) {

        this.dir_id = dir_id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setNationality(String nationality) {

        this.nationality = nationality;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dir_id", referencedColumnName = "id")
    Director director;

}

