package menus;

import controllers.PersonController;
import controllers.TeacherControllerImpl;
import model.Teacher;
import prodein.DI;
import repo.PersonDAO;
import repo.TeacherService;


import java.util.Scanner;

public class TeacherMenu implements Menu {
    DI di;


    public TeacherMenu(DI di) {
        this.di = di;
    }

    @Override
    public void showMenu() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(
                    "\nChoose an option to manage Teacher:\n" +
                            "A-> Add a Teacher\n" +
                            "D-> Delete a Teacher\n" +
                            "U-> Update a Teacher\n" +
                            "G-> Get a Teacher\n" +
                            "X-> Get all Teachers\n" +
                            "&-> Delete all Teachers\n" +
                            "*-> Goto Main Menu\n" +
                            "Q-> Quit Application\n>>> ");

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
                case '*':
                    return;
                case '&':
                    deleteAllMenu();
                    break;
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
    public void addMenu() {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher details to save in Database");
        System.out.print("Name of the teacher:: ");
        teacher.setName(scanner.nextLine());
        System.out.print("Age of the teacher:: ");
        teacher.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Location of the teacher:: ");
        teacher.setLocation(scanner.nextLine());
        System.out.print("Height of the teacher:: ");
        teacher.setHeight(scanner.nextDouble());

        PersonController personController = di.instance(TeacherControllerImpl.class);
        personController.create(teacher);
    }

    @Override
    public void deleteMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter id to delete:: ");
        int id = scanner.nextInt();


        PersonController personController = di.instance(TeacherControllerImpl.class);
        personController.delete(id);
    }

    @Override
    public void updateMenu() {
        Scanner scanner = new Scanner(System.in);
        PersonController personController = di.instance(TeacherControllerImpl.class);
        PersonDAO personDAO = di.instance(TeacherService.class);

        Teacher teacher = new Teacher();
        System.out.print("ID of Teacher to update:: ");
        int id = scanner.nextInt();

        if (personDAO.get(id) == null) {
            System.out.printf("%s %d\n", "No Teacher found for ID >> ", id);

            return;
        }

        teacher.setId(id);
        scanner.nextLine();
        System.out.print("New name:: ");
        teacher.setName(scanner.nextLine());
        System.out.print("New Age:: ");
        teacher.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("New location:: ");
        teacher.setLocation(scanner.nextLine());
        System.out.print("New height:: ");
        teacher.setHeight(scanner.nextDouble());

        personController.update(teacher);
    }

    @Override
    public void getMenu() {
        Scanner scanner = new Scanner(System.in);
        PersonController personController = di.instance(TeacherControllerImpl.class);
        System.out.print("Please enter Teacher ID to get::");
        int id = scanner.nextInt();

        personController.get(id);

    }

    @Override
    public void deleteAllMenu() {
        PersonController personController = di.instance(TeacherControllerImpl.class);
        personController.deleteAll();
    }

    @Override
    public void getAllMenu() {
        PersonController personController = di.instance(TeacherControllerImpl.class);
        personController.getAll();

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
