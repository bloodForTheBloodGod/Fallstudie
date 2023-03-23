package ch.bbcag.backend.todolist.item;


import ch.bbcag.backend.todolist.person.Person;
import ch.bbcag.backend.todolist.tag.Tag;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "item_linked_tags",
            joinColumns = @JoinColumn(name = "item_id"))
    private Set<Tag> tags = new LinkedHashSet<>();


    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    @ManyToMany
    @JoinTable(
            name = "item_tag",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> linkedTags = new HashSet<>();

    public Item() {
    }

    public Set<Tag> getLinkedTags() {
        return linkedTags;
    }

    public void setLinkedTags(Set<Tag> linkedTags) {
        this.linkedTags = linkedTags;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Timestamp getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(Timestamp doneAt) {
        this.doneAt = doneAt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
