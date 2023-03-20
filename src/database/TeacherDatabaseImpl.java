package database;


import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherDatabaseImpl implements PersonDatabase {
    private final List<Person> db=new ArrayList<>();
    private int insertCount;

    @Override
    public int create(Person person) {
        int id=++insertCount;
        person.setId(id);
        db.add(person);
        return id;
    }

    @Override
    public boolean deleteAll() {
        db.clear();
        return true;
    }

    @Override
    public Person get(Integer personId) {
        Optional<Person> optional = db.stream().filter((person -> person.getId() == personId)).findFirst();
        return optional.orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(db);
    }

    @Override
    public boolean update(Person person) {
        if (db.removeIf((person1 -> person1.getId() == person.getId())))
            return db.add(person);
        else
            return false;
    }

    @Override
    public boolean delete(Integer personId) {
        Optional<Person> optional = db.stream().filter((person) -> person.getId() == personId).findFirst();
        return optional.map(db::remove).orElse(false);
    }

    @Override
    public int size() {
        return db.size();
    }
}
