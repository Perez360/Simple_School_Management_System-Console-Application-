package repo;


import database.PersonDatabase;
import database.StudentDatabaseImpl;
import model.Person;
import prodein.DI;

import java.util.List;

public class StudentService implements PersonDAO {
    DI di;

    public StudentService(DI di) {
        this.di = di;
    }

    @Override
    public int create(Person person) {
        PersonDatabase personDatabase = di.instance("studentDB", StudentDatabaseImpl.class);
        return personDatabase.create(person);
    }

    @Override
    public boolean update(Person person) {
        PersonDatabase personDatabase = di.instance("studentDB", StudentDatabaseImpl.class);
        return personDatabase.update(person);
    }

    @Override
    public Person get(Integer studentId) {
        PersonDatabase personDatabase = di.instance("studentDB", StudentDatabaseImpl.class);
        return personDatabase.get(studentId);
    }

    @Override
    public List<Person> getAll() {
        PersonDatabase personDatabase = di.instance("studentDB", StudentDatabaseImpl.class);
        return personDatabase.getAll();
    }

    @Override
    public boolean delete(Integer studentId) {
        PersonDatabase personDatabase = di.instance("studentDB", StudentDatabaseImpl.class);
        return personDatabase.delete(studentId);
    }

    @Override
    public boolean deleteAll() {
        PersonDatabase personDatabase=di.instance("studentDB",StudentDatabaseImpl.class);
        return personDatabase.deleteAll();
    }

    @Override
    public int size() {
        PersonDatabase personDatabase = di.instance("studentDB", StudentDatabaseImpl.class);
        return personDatabase.size();
    }
}
