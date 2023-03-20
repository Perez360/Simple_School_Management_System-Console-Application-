package menus;

import controllers.PersonController;
import controllers.StudentControllerImpl;
import model.Student;
import prodein.DI;
import repo.PersonDAO;
import repo.StudentService;


import java.util.Scanner;

public class StudentMenu implements Menu {
    DI di;

    public StudentMenu(DI di) {
        this.di = di;
    }

    @Override
    public void showMenu() {


        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.print(
                    "\nChoose an option to manage Student:\n" +
                            "A-> Add a Student\n" +
                            "D-> Delete a Student\n" +
                            "U-> Update a Student\n" +
                            "G-> Get a Student\n" +
                            "X-> Get all Students\n" +
                            "&-> Delete all Students\n" +
                            "*-> Goto Main Menu\n" +
                            "Q-> Quit Application\n>>>");
            char res = scanner.nextLine().toUpperCase().charAt(0);
            switch (res) {
                case 'A':
                    addMenu();
                    break;
                case 'D':
                    deleteMenu();
                    break;
                case 'U':
                    updateMenu();
                    break;
                case 'G':
                    getMenu();
                    break;
                case 'X':
                    getAllMenu();
                    break;
                case '&':
                    deleteAllMenu();
                    break;
                case '*':
                    return;
                case 'Q':
                    exit();
                    break;
                default:
                    unknownSelection();
                    break;
            }
        }
    }

    @Override
    public void getAllMenu() {
        PersonController personController = di.instance(StudentControllerImpl.class);
        personController.getAll();
    }


    @Override
    public void addMenu() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter Student details to save in Database");
        System.out.print("Name of the student:: ");
        student.setName(scanner.nextLine());
        System.out.print("Age of the student:: ");
        student.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Location of the student:: ");
        student.setLocation(scanner.nextLine());
        System.out.print("Height of the student:: ");
        student.setHeight(scanner.nextDouble());

        PersonController personController = di.instance(StudentControllerImpl.class);
        personController.create(student);

    }

    @Override
    public void deleteAllMenu() {
        PersonController personController = di.instance(StudentControllerImpl.class);
        personController.deleteAll();
    }

    @Override
    public void deleteMenu() {
        Scanner scanner = new Scanner(System.in);
        PersonController personController = di.instance(StudentControllerImpl.class);
        System.out.print("Please enter Student ID to delete:: ");
        int id = scanner.nextInt();

        personController.delete(id);

    }

    @Override
    public void updateMenu() {
        Scanner scanner = new Scanner(System.in);
        PersonController personController = di.instance(StudentControllerImpl.class);
        PersonDAO personDAO = di.instance(StudentService.class);

        Student student = new Student();
        System.out.print("ID of Student to update:: ");
        int id = scanner.nextInt();

        if (personDAO.get(id) == null) {
            System.out.printf("%s %d\n", "No Student found for ID >> ", id);

            return;
        }

        student.setId(id);
        scanner.nextLine();
        System.out.print("New name:: ");
        student.setName(scanner.nextLine());
        System.out.print("New location:: ");
        student.setLocation(scanner.nextLine());

        System.out.print("New age:: ");
        student.setAge(scanner.nextInt());
        System.out.print("New height:: ");
        student.setHeight(scanner.nextDouble());

        personController.update(student);
    }

    @Override
    public void getMenu() {
        Scanner scanner = new Scanner(System.in);
        PersonController personController = di.instance(StudentControllerImpl.class);
        System.out.print("Please enter Student ID to get:: ");
        int id = scanner.nextInt();

        personController.get(id);

    }

    @Override
    public void exit() {
        System.out.println("Thanks for your time. Bye...");
        System.exit(0);
    }


    @Override
    public void unknownSelection() {
        System.out.println("Invalid option selected.\nTry again");
    }

}
