package com.example.myapplication;

public class StudentMod {
    private int id;
    private String name;
    private int age;
    //getear
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
//constrctor


    public StudentMod(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //stear


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString

    @Override
    public String toString() {
        return "StudentMod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
