package test.entity;

import java.util.Date;

/**
 * Created by on 04.04.16.
 */
public class Employee {

    private int id;
    private String name;
    private String email;
    private double salary;
    private Date date;

    public Employee(int id, String name, String email, double salary, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
