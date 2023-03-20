package repo;


import database.Database;
import model.Course;

public interface CourseDAO extends Database<Course, Integer> {

    int create(Course course);

    boolean update(Course course);

    Course get(Integer courseId);

    boolean delete(Integer courseId);
}
