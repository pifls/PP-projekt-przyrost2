package hibernate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue
    @JsonProperty
    @Column(name = "id")
    private int id;

    @JsonProperty
    @Column(name = "title")
    private String title;

    @JsonProperty
    @Column(name = "year")
    private int year;

    @JsonProperty
    @Column(name = "genre")
    private String genre;

    @JsonProperty
    @Column(name = "country")
    private String country;


    public Film() {
    }

    // Getters //

    public int getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public int getYear() {

        return year;
    }

    public String getGenre() {

        return genre;
    }

    public String getCountry() {

        return country;
    }


    // Setters //

    public void setId(int id) {

        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public void setGenre(String director) {

        this.genre = director;
    }

    public void setCountry(String country) {

        this.country = country;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "dir_id")
    private Director director;


    @ManyToMany(mappedBy = "films", cascade = CascadeType.ALL)
    private List<Film> directors = new ArrayList<Film>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<>();
}

