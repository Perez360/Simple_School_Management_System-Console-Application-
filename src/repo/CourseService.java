package repo;

import database.CourseDatabaseImpl;
import database.Database;
import model.Course;
import prodein.DI;

import java.util.List;


public class CourseService implements CourseDAO {
    DI di;

    @Override
    public boolean deleteAll() {
        Database<Course, Integer> database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.deleteAll();
    }

    public CourseService(DI di) {
        this.di = di;
    }

    @Override
    public int create(Course course) {
        /*Getting our singleton instance from di*/
        Database<Course, Integer> database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.create(course);

    }

    @Override
    public boolean update(Course course) {

        Database<Course, Integer> database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.update(course);
    }

    @Override
    public Course get(Integer courseId) {
        Database<Course, Integer> database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.get(courseId);
    }

    @Override
    public List<Course> getAll() {
        CourseDatabaseImpl database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.getAll();
    }

    @Override
    public boolean delete(Integer courseId) {
        CourseDatabaseImpl database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.delete(courseId);
    }

    @Override
    public int size() {
        CourseDatabaseImpl database = di.instance("courseDB", CourseDatabaseImpl.class);
        return database.size();
    }
}
