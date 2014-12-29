package org.example.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * A domain object example. In a real application this would probably be a JPA
 * entity or DTO.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Entry.byName", query = "SELECT e FROM PhoneBookEntry AS e WHERE E.name LIKE :filter")
})

public class PhoneBookEntry extends AbstractEntity {

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 40, message = "name must be longer than 3 and less than 40 characters")
    private String name;

    @Size(max = 25, message = "Only 25 characters allowed")
    private String number;

    @NotNull(message = "Email is required")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Must be valid email")
    private String email;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;

    @ManyToMany
    private List<PhoneBookGroup> groups = new ArrayList<>();

    public PhoneBookEntry(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public PhoneBookEntry() {
        this("", "", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<PhoneBookGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<PhoneBookGroup> groups) {
        this.groups = groups;
    }

}
