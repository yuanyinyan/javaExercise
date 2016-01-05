package com.javaExercise.listSetMap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuanyin on 16/1/2.
 */
public class Student {
    private String id;
    private String name;
    private Set<Course> courses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet<Course>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
