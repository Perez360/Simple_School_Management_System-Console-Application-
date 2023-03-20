package controllers;



import model.Person;
import prodein.DI;
import repo.PersonDAO;
import repo.TeacherService;

import java.util.List;

public class TeacherControllerImpl implements PersonController {
    DI di;

    public TeacherControllerImpl(DI di) {
        this.di = di;
    }

    @Override
    public void create(Person person) {
        PersonDAO personDAO = di.instance(TeacherService.class);
        int savedId = personDAO.create(person);

        System.out.println("************ Teacher successfully saved ************\n");
        System.out.println(personDAO.get(savedId));
    }

    @Override
    public void deleteAll() {
        PersonDAO personDAO = di.instance(TeacherService.class);
        if (personDAO.deleteAll())
            System.out.println("************ Successfully deleted all Teachers ************");
    }

    @Override
    public void update(Person person) {
        PersonDAO personDAO = di.instance(TeacherService.class);

        if (personDAO.update(person))
            System.out.println("************ Teacher successfully updated ************");
        else
            System.err.println("************ Failed to update Teacher ************");

    }

    @Override
    public void delete(Integer personId) {
        PersonDAO personDAO = di.instance(TeacherService.class);
        if (personDAO.delete(personId))
            System.out.println("************ Teacher successfully deleted ************");
        else
            System.err.println("************ Failed to delete Teacher ************");

    }

    @Override
    public void get(Integer personId) {
        PersonDAO personDAO = di.instance(TeacherService.class);
        Person person = personDAO.get(personId);
        if (person == null) {
            System.out.printf("%s %d", "No Teacher found for ID >> ", personId);
        } else {
            System.out.println("*********** Found a Teacher ***********");
            System.out.println(person);
        }
    }

    @Override
    public void getAll() {
        PersonDAO personDAO = di.instance(TeacherService.class);
        List<Person> personList = personDAO.getAll();

        System.out.println("*********** List of Teachers ***********\n");
        if (!personList.isEmpty()) {
            System.out.println("Found some Teacher(s)\n");
        } else {
            System.out.println("No Teachers found ");
        }
        personList.forEach(System.out::println);
        System.out.println("\n*********** List of Teachers ***********\n");
    }


}
