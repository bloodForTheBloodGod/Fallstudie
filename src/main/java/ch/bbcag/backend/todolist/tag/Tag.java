package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.Item;
import org.hibernate.validator.constraints.UniqueElements;


import javax.persistence.*;
import java.security.PrivateKey;
import java.util.Set;

@Entity
public class Tag {

    @ManyToMany
    private Set<Item> LinkedItems;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @UniqueElements
    private String name;


}
