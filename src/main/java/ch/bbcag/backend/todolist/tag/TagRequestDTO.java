package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.Item;

import java.util.Set;

public class TagRequestDTO {

    private String name;

    public Set<Item> itemIds;

    public Set<Item> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Item> itemIds) {
        this.itemIds = itemIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
