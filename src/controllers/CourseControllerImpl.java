package controllers;


import model.Course;
import prodein.DI;
import repo.CourseService;


import java.util.List;

public class CourseControllerImpl implements CourseController {
    DI di;


    public CourseControllerImpl(DI di) {
        this.di = di;
    }

    @Override
    public void create(Course course) {
        CourseService courseService = di.instance(CourseService.class);
        int savedId = courseService.create(course);
        System.out.println("************ Course successfully saved ************\n");
        System.out.println(courseService.get(savedId));
    }

    @Override
    public void update(Course course) {
        CourseService courseService = di.instance(CourseService.class);
        if (courseService.update(course))
            System.out.println("************ Course successfully updated ************");
        else
            System.err.println("************ Failed to update Course ************");
    }

    @Override
    public void deleteAll() {
        CourseService courseService = di.instance(CourseService.class);
        courseService.deleteAll();
    }

    @Override
    public void delete(Integer courseId) {
        CourseService courseService = di.instance(CourseService.class);
        if (courseService.delete(courseId))
            System.out.println("************ Course successfully deleted ************");
        else
            System.out.println("No Course found for ID >> " + courseId);
    }

    @Override
    public void get(Integer courseId) {

        CourseService courseService = di.instance(CourseService.class);
        Course course = courseService.get(courseId);
        if (course == null) {
            System.out.println("No Course found for ID >> " + courseId);
        } else {
            System.out.println("*********** Found a Course ***********");
            System.out.println(courseId);
        }
    }

    @Override
    public void getAll() {
        CourseService courseService = di.instance(CourseService.class);
        List<Course> courseList = courseService.getAll();

        System.out.println("*********** List of Courses ***********\n");
        if (!courseList.isEmpty())
            System.out.println("Found some Course(s)\n");
        else {
            System.out.println("No Courses found ");
        }
        courseList.forEach(System.out::println);
        System.out.println("\n*********** List of Courses ***********\n");
    }


}
