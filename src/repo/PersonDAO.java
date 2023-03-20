package repo;


import model.Person;

import java.util.List;

public interface PersonDAO  {

    int create(Person person);

    boolean update(Person person);

    Person get(Integer personId);

    List<Person> getAll();

    boolean delete(Integer personId);
    boolean deleteAll();

    int size();
}
