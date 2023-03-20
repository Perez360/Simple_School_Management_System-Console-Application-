package model;

public class Teacher extends Person {

    public Teacher(String name, int age, String location, double height) {
        super(name, age, location, height);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", age= " + age +
                ", location= '" + location + '\'' +
                ", height= " + height +
                '}';
    }

    public Teacher() {

    }
}
