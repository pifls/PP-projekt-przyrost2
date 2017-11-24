package hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.model.Director;
import hibernate.model.Film;
import hibernate.queries.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;

class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Queries query = new Queries(entityManager);

            Film film1 = new Film();
            film1.setTitle("Shutter Island");
            film1.setGenre("thriller");
            film1.setYear(2012);
            film1.setCountry("USA");

            entityManager.persist(film1);

            Film film_1 = entityManager.find(Film.class, film1.getId());


            Film film2 = new Film();
            film2.setTitle("The Salt of the Earth");
            film2.setGenre("biography");
            film2.setYear(2014);
            film2.setCountry("France");

            entityManager.persist(film2);

            Film film_2 = entityManager.find(Film.class, film2.getId());


            Director dir1 = new Director();
            dir1.setName("Martin");
            dir1.setSurname("Scorsese");
            dir1.setAge(75);
            dir1.setNationality("USA");

            entityManager.persist(dir1);

            Film dir_1 = entityManager.find(Film.class, dir1.getDir_id());


            Director dir2 = new Director();
            dir2.setName("Christopher");
            dir2.setSurname("Nolan");
            dir2.setAge(47);
            dir2.setNationality("England");

            entityManager.persist(dir2);

            Film dir_2 = entityManager.find(Film.class, dir2.getDir_id());



            ObjectMapper mapper = new ObjectMapper();

            //Object to JSON in file
            mapper.writeValue(new File("film.json"), film1);
            mapper.writeValue(new File("film.json"), film2);
            mapper.writeValue(new File("dir.json"), dir1);
            mapper.writeValue(new File("dir.json"), dir2);





            // entityManager.remove(emp);

            entityManager.getTransaction().commit();
            System.out.println("Done");
            entityManager.close();





        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

    }
