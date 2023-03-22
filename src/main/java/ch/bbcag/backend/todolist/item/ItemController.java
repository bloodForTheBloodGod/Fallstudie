package ch.bbcag.backend.todolist.item;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(ItemController.PATH)
public class ItemController {


    public static final String PATH = "/items";

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> findByID(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(itemService.findById(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ItemRequestDTO newItem) {
        try {
            itemService.insert(newItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(itemService.insert(newItem));
        } catch (Error e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            itemService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findItems(@RequestParam(required = false) String name) {
        if (StringUtils.isNotBlank(name)) {
            return ResponseEntity.ok(itemService.findByName(name));
        }
        return ResponseEntity.ok(itemService.findAll());
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, ItemRequestDTO itemRequestDTO) {
        try {
            itemService.update(itemRequestDTO, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Error e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }



}