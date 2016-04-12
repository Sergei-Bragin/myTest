package test.entity;

import lombok.Data;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

import test.util.validation.EnglishLetters;
import test.util.validation.UniqueNameDep;

import javax.persistence.*;

/**
 * Created by on 04.04.16.
 */
@Entity
@Table(name="dep")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 16, message = "Name must be range from 3 to 16 characters")
    @NotEmpty(message = "Name can't be empty!")
    @UniqueNameDep
    @EnglishLetters
    private String name;

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
}
