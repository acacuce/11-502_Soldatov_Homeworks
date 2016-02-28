package ru.itis.inform;

/**
 * Created by acacuce on 24.02.16.
 */
public class Human {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString () {
        return name + " " + age ;

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
