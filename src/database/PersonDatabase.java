package database;


import model.Person;

import java.util.List;

public interface PersonDatabase extends Database<Person, Integer> {
    int create(Person person);

    boolean update(Person person);

    boolean delete(Integer personId);

    boolean deleteAll();

    Person get(Integer personId);

    List<Person> getAll();
}
