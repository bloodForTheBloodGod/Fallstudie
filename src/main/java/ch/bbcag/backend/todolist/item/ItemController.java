package ch.bbcag.backend.todolist.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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



    @GetMapping(path = "{id}")
    public Item findByID(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(itemServise.findByid(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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