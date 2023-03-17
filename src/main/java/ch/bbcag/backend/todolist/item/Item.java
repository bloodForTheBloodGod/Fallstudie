package ch.bbcag.backend.todolist.item;


import ch.bbcag.backend.todolist.person.Person;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Item {

    private String description;

    private String name;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer id;


    @Column(insertable = false)
    private Timestamp createdAt;

    private Timestamp deletedAt;

    private Timestamp doneAt;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;




    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public Timestamp getDoneAt() {
        return doneAt;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(description, item.description) && Objects.equals(name, item.name) && Objects.equals(id, item.id) && Objects.equals(createdAt, item.createdAt) && Objects.equals(deletedAt, item.deletedAt) && Objects.equals(doneAt, item.doneAt) && Objects.equals(person, item.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, id, createdAt, deletedAt, doneAt, person);
    }
}
