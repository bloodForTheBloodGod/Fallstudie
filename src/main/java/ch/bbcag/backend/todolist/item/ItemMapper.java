package ch.bbcag.backend.todolist.item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemMapper {

    @Autowired
    private ItemRepository repository;

    public Optional<Item> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Item> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Item> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Item insert(ItemRequestDTO dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setDoneAt(dto.getDoneAt());
        return repository.save(item);

    }
}
