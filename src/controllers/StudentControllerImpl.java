package controllers;



import model.Person;
import prodein.DI;
import repo.PersonDAO;
import repo.StudentService;

import java.util.List;

public class StudentControllerImpl implements PersonController {
    DI di;

    public StudentControllerImpl(DI di) {
        this.di = di;
    }

    @Override
    public void create(Person person) {
        PersonDAO personDAO = di.instance(StudentService.class);
        int savedId = personDAO.create(person);

        System.out.println("************ Student successfully saved ************\n");
        System.out.println(personDAO.get(savedId));
    }

    @Override
    public void update(Person person) {
        PersonDAO personDAO = di.instance(StudentService.class);
        if (personDAO.update(person))
            System.out.println("************ Student successfully updated ************");
        else
            System.err.println("************ Failed to update Student ************");
    }

    @Override
    public void delete(Integer personId) {
        PersonDAO personDAO = di.instance(StudentService.class);
        if (personDAO.delete(personId))
            System.out.println("************ Student successfully deleted ************");
        else
            System.out.println("No Student found for ID >> " + personId);
    }

    @Override
    public void deleteAll() {
        PersonDAO personDAO=di.instance(StudentService.class);
        if (personDAO.deleteAll())
            System.out.println("************ Successfully deleted all Students ************");
    }

    @Override
    public void get(Integer personId) {
        PersonDAO personDAO = di.instance(StudentService.class);
        Person person = personDAO.get(personId);
        if (person == null) {
            System.out.printf("%s %d", "No Student found for ID >> ", personId);
        } else {
            System.out.println("*********** Found a Student ***********");
            System.out.println(person);
        }
    }

    @Override
    public void getAll() {
        PersonDAO personDAO = di.instance(StudentService.class);
        List<Person> personList = personDAO.getAll();


        System.out.println("*********** List of Students ***********\n");
        if (!personList.isEmpty())
            System.out.println("Found some Student(s)\n");
        else {
            System.out.println("No Students found ");
        }
        personList.forEach(System.out::println);
        System.out.println("\n*********** List of Students ***********\n");
    }
}
