package model;

public class Course {
    private int id;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id= " + id +
                ", duration= " + duration +
                ", courseName= '" + courseName + '\'' +
                '}';
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
