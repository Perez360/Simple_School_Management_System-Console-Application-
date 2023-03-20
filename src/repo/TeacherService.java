package repo;



import database.PersonDatabase;
import database.TeacherDatabaseImpl;
import model.Person;
import prodein.DI;

import java.util.List;

public class TeacherService implements PersonDAO {
    DI di;

    public TeacherService(DI di) {
        this.di = di;
    }

    @Override
    public int create(Person person) {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.create(person);
    }

    @Override
    public boolean update(Person person) {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.update(person);
    }


    @Override
    public Person get(Integer personId) {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.get(personId);
    }

    @Override
    public List<Person> getAll() {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.getAll();
    }

    @Override
    public boolean delete(Integer personId) {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.delete(personId);
    }

    @Override
    public boolean deleteAll() {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.deleteAll();
    }

    @Override
    public int size() {
        PersonDatabase personDatabase = di.instance("teacherDB", TeacherDatabaseImpl.class);
        return personDatabase.size();
    }
}
