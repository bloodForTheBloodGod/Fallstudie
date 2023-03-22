package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.Item;

import java.util.List;
import java.util.Set;

public class TagResponseDTO {

    public Integer id;
    public List<Integer> itemIds;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(Set<Item> itemIds) {
        this.itemIds = itemIds;
    }
}
