package controllers;


import model.Person;

public interface PersonController {
    void create(Person person);

    void update(Person person);

    void delete(Integer personId);
    void deleteAll();

    void get(Integer personId);

    void getAll();
}
