package database;


import model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseDatabaseImpl implements Database<Course, Integer> {
    private final List<Course> db = new ArrayList<>();
    private int insertCount;

    public int create(Course course) {
        int id = ++insertCount;
        course.setId(id);
        db.add(course);
        return id;
    }

    @Override
    public Course get(Integer courseId) {
        Optional<Course> optional = db.stream().filter((course -> course.getId() == courseId)).findFirst();
        return optional.orElse(null);
    }

    @Override
    public boolean update(Course course) {
        if (db.removeIf((course1 -> course1.getId() == course.getId())))
            return db.add(course);
        else
            return false;
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(db);
    }

    @Override
    public boolean delete(Integer courseId) {
        Optional<Course> optional = db.stream().filter((course) -> course.getId() == courseId).findFirst();
        return optional.map(db::remove).orElse(false);
    }

    @Override
    public boolean deleteAll() {
        db.clear();
        return true;
    }

    @Override
    public int size() {
        return db.size();
    }
}
