package menus;



import controllers.CourseController;
import controllers.CourseControllerImpl;
import model.Course;
import prodein.DI;
import repo.CourseDAO;
import repo.CourseService;

import java.util.Scanner;

public class CourseMenu implements Menu {
    DI di;


    public CourseMenu(DI di) {
        this.di = di;
    }


    @Override
    public void showMenu() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(
                    "\nChoose an option to manage Course:\n" +
                            "A-> Add a Course\n" +
                            "D-> Delete a Course\n" +
                            "U-> Update a Course\n" +
                            "G-> Get Course info\n" +
                            "X-> Get all Courses\n" +
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
    public void addMenu() {
        Scanner scanner = new Scanner(System.in);
        Course course = new Course();
        System.out.println("Enter Course details to save in Database");
        System.out.print("Name of Course:: ");
        course.setCourseName(scanner.nextLine());
        System.out.print("Course duration in (eg. 20):: ");
        course.setDuration(scanner.nextInt());

        CourseController courseController = di.instance(CourseControllerImpl.class);
        courseController.create(course);
    }

    @Override
    public void deleteMenu() {
        Scanner scanner = new Scanner(System.in);
        CourseController courseController = di.instance(CourseControllerImpl.class);
        System.out.print("Please enter Course ID to delete:: ");
        int id = scanner.nextInt();

        courseController.delete(id);

    }

    @Override
    public void deleteAllMenu() {
        CourseController courseController = di.instance(CourseControllerImpl.class);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are your sure you want to delete all the Courses- Y / N:: ");
        char res = scanner.nextLine().toUpperCase().charAt(0);
        switch (res) {
            case 'Y':
                courseController.deleteAll();
            case 'N':
                break;
            default:
        }

    }

    @Override
    public void updateMenu() {
        Scanner scanner = new Scanner(System.in);
        CourseController courseController = di.instance(CourseControllerImpl.class);
        CourseDAO courseDAO = di.instance(CourseService.class);

        Course course = new Course();
        System.out.print("ID of Course to update:: ");

        int id = scanner.nextInt();

        if (courseDAO.get(id) == null) {
            System.out.printf("%s %d\n", "No Course found for ID >> ", id);

            return;
        }

        course.setId(id);
        scanner.nextLine();
        System.out.print("New name:: ");
        course.setCourseName(scanner.nextLine());
        System.out.print("New duration:: ");
        course.setDuration(scanner.nextInt());

        courseController.update(course);
    }

    @Override
    public void getMenu() {
        Scanner scanner = new Scanner(System.in);
        CourseController courseController = di.instance(CourseControllerImpl.class);
        System.out.print("Please enter Course ID to get:: ");
        int id = scanner.nextInt();

        courseController.get(id);
    }

    @Override
    public void getAllMenu() {
        CourseController courseController = di.instance(CourseControllerImpl.class);
        courseController.getAll();
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
