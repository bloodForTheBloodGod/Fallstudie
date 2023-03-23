package ch.bbcag.backend.todolist.item;

import ch.bbcag.backend.todolist.tag.Tag;

import java.sql.Timestamp;
import java.util.Set;

public class ItemResponseDTO extends ItemRequestDTO{

    public Integer id;

    public  Set<Integer> TagIds;

    public Set<Integer> getTagIds() {
        return TagIds;
    }

    public void setTagIds(Set<Integer> tagIds) {
        TagIds = tagIds;
    }

    private Timestamp createdAt;

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
}
