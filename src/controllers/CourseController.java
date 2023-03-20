package controllers;


import model.Course;

public interface CourseController {
    void create(Course course);

    void update(Course course);

    void delete(Integer courseId);
    void deleteAll();

    void get(Integer courseId);

    void getAll();
}
