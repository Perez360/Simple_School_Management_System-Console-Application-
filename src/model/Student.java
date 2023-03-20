package model;

public class Student extends Person {

    public Student() {
    }

    public Student(String name, int age, String location, double height) {
        super(name, age, location, height);
    }


    @Override
    public String toString() {
        return "Student { " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", age= " + age +
                ", location= '" + location + '\'' +
                ", height= " + height +
                '}';
    }
}
