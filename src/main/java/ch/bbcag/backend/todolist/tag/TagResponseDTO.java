package ch.bbcag.backend.todolist.tag;

import java.util.List;

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

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
