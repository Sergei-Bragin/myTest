package test.entity;

import lombok.Data;
import net.sf.oval.constraint.*;
import test.util.validation.EnglishLetters;
import test.util.validation.UniqueEmplEmail;

import java.util.Date;

/**
 * Created by on 04.04.16.
 */
@Data public class Employee {


    private Integer id;

    @Size(min = 2 , max = 20, message = "Name must be range from 3 to 20 characters")
    @NotEmpty( message = "Name can't be empty!")
    private String name;


    @NotEmpty( message = "Email can't be empty!")
    @UniqueEmplEmail
    @Email(message = "Email incorrect")
    private String email;


    @NotEmpty( message = "Salary can't be empty!")
    @NotNull(message = "Please use the numbers")
    @NotNegative (message = "Salary can't be empty")
    private Double salary;

    @NotNull(message = "Cant be Empty")
    @NotEmpty(message = "Date can't be empty")
    private Date date;


    private Integer depId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}
