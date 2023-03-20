package menus;

import prodein.DI;


/*In this application menus can be classified as our endpoints or routes*/
public class MainMenu {
    DI di;

    public MainMenu(DI di) {
        this.di = di;
    }

    public void showMenu() {
        System.out.print(
                "\nHello "+System.getenv("USERNAME")+"! Welcome to our School Management System.\n" +
                        "Choose your choice:\n" +
                        "S-> Manage Students\n" +
                        "T-> Manage Teachers\n" +
                        "C-> Manage Courses\n" +
                        "Q-> Quit Application\n>>> ");
    }

    public void manageStudent() {
        Menu menu = di.instance(StudentMenu.class);
        menu.showMenu();
    }

    public void manageTeacher() {
        Menu menu = di.instance(TeacherMenu.class);
        menu.showMenu();
    }

    public void manageCourse() {
        Menu menu=di.instance(CourseMenu.class);
        menu.showMenu();
    }
    public void exit() {
        System.out.println("Thanks for your time. Bye...");
    }
    public void unknownSelection() {
        System.out.println("Invalid option selected.\nTry again");
    }

}
