import controllers.CourseControllerImpl;
import controllers.StudentControllerImpl;
import controllers.TeacherControllerImpl;
import database.CourseDatabaseImpl;
import database.PersonDatabase;
import database.StudentDatabaseImpl;
import database.TeacherDatabaseImpl;
import menus.CourseMenu;
import menus.MainMenu;
import menus.StudentMenu;
import menus.TeacherMenu;
import prodein.DI;
import prodein.DIFactory;
import repo.CourseService;
import repo.StudentService;
import repo.TeacherService;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    DI di;

    public void startApplication() {
        /*Instantiating our DI*/
        di = new DIFactory();


        /*Binding all instances we will need throughout the application*/
        di.bindSingleton(new StudentMenu(di));
        di.bindSingleton(new TeacherMenu(di));
        di.bindSingleton(new CourseMenu(di));
        di.bindSingleton(new MainMenu(di));
        di.bindSingleton(new StudentControllerImpl(di));
        di.bindSingleton(new TeacherControllerImpl(di));
        di.bindSingleton(new CourseControllerImpl(di));
        di.bindSingleton(new StudentService(di));
        di.bindSingleton(new TeacherService(di));
        di.bindSingleton(new CourseService(di));

        /*You can also tag your instances and call them by their various tags when ever you need them.
          Note Exceptions will be thrown when bindings are not handled properly */
        di.bindSingleton("studentDB", new StudentDatabaseImpl());
        di.bindSingleton("teacherDB", new TeacherDatabaseImpl());
        di.bindSingleton("courseDB", new CourseDatabaseImpl());


        System.out.println("*********************** TESTING ***************************");
        testing();
        System.out.println("\n*********************** TESTING ***************************\n");


        Scanner scanner = new Scanner(System.in);

        MainMenu mainMenu = di.instance(MainMenu.class);
        while (true) {
            mainMenu.showMenu();
            char res = scanner.nextLine().toUpperCase().charAt(0);
            switch (res) {
                case 'S':
                    mainMenu.manageStudent();
                    break;
                case 'T':
                    mainMenu.manageTeacher();
                    break;
                case 'C':
                    mainMenu.manageCourse();
                    break;
                case 'Q':
                    mainMenu.exit();
                    return;
                default:
                    mainMenu.unknownSelection();
            }
        }
    }

    public void testing() {
        /* Before we start, lets test our singleton instances*/

        PersonDatabase personDatabase1 = di.instance("studentDB", StudentDatabaseImpl.class);
        PersonDatabase personDatabase2 = di.instance("studentDB", StudentDatabaseImpl.class);
        System.out.printf("%s%b\n", "PersonDAO 1 == PersonDAO 2 >>>>>> ", Objects.deepEquals(personDatabase1, personDatabase2));

        System.out.println("\nNow let see all the singleton instances we have bounded in our application from our container.\n   ");
        int count = 1;
        for (Object object : di.getAllBindings()) {
            System.out.printf("%d-> %s\n", count++, object);
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startApplication();
    }
}
