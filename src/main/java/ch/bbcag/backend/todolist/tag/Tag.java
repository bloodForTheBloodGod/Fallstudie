package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.Item;
import org.hibernate.validator.constraints.UniqueElements;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tag {

    @ManyToMany
    private Set<Item> LinkedItems;

    @UniqueElements
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public Set<Item> getLinkedItems() {
        return LinkedItems;
    }

    public void setLinkedItems(Set<Item> linkedItems) {
        LinkedItems = linkedItems;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag tag)) return false;
        return Objects.equals(getId(), tag.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
