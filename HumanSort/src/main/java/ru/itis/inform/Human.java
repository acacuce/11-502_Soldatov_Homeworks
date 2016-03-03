package ru.itis.inform;

/**
 * Created by acacuce on 24.02.16.
 */
public class Human {
    private int age;
    private String name;

    public Human( String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString (){
        return name + " " + age ;

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null) return false;
        if (another == this) return true;
        if (!(another instanceof Human)) return false;
        Human anotherHuman = (Human) another;
        if (this.toString().equals(anotherHuman.toString())) {
            return true;
        }else return false;
    }
}
