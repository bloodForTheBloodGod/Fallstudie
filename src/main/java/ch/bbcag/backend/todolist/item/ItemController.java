package ch.bbcag.backend.todolist.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping(ItemController.PATH)
public class ItemController {
    public static final String PATH = "/items";
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("{id}")
    public Item findByID(@PathVariable Integer id) {
        return itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public Item insert(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }

    @GetMapping
    public List<Item> findItems(String name) {
        if (name == null) {
            return itemRepository.findAll();
        } else {
            return itemRepository.findByName(name);
        }
    }
}