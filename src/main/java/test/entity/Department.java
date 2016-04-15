package test.entity;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;
import test.util.validation.EnglishLetters;
import test.util.validation.UniqueNameDep;

/**
 * Created by on 04.04.16.
 */
public class Department {

    private Integer id;

    @NotNull
    @Size(min = 3, max = 16, message = "Name must be range from 3 to 16 characters")
    @NotEmpty(message = "Name can't be empty!")
    @UniqueNameDep
    @EnglishLetters
    private String name;

    private byte[] icon;

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public Department() {
    }

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
