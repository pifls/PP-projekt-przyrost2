package hibernate.queries;

import hibernate.model.Director;
import hibernate.model.Film;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {

        this.entityManager = entityManager;
    }


    public List<Film> getFilms(){
        Query query = entityManager.createQuery("SELECT f from Film f");
        return query.getResultList();
    }


    public List<Director> getDirectors(){
        Query query = entityManager.createQuery("SELECT d from Director d");
        return query.getResultList();
    }

    public List<Film> getFilmsAfter2k(int year){
        Query query = entityManager.createQuery("SELECT k from Director k WHERE k.year > 2000");
        return query.getResultList();
    }

    public List<Director> getDirectorrsPolish(String nationality){
        Query query = entityManager.createQuery("SELECT n from Director n WHERE n.nationality = 'Poland' ");
        return query.getResultList();
    }

    public List<Film> getFilmComedy(String genre){
        Query query = entityManager.createQuery("SELECT n from Director n WHERE n.genre = 'comedy' ");
        return query.getResultList();
    }











}