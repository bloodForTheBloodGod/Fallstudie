package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.Item;

import java.util.Set;

public class TagResponseDTO {

    public Integer id;
    public Set<Item> itemIds;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Item> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Item> itemIds) {
        this.itemIds = itemIds;
    }
}
