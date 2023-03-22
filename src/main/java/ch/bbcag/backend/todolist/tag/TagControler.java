package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.ItemRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(TagControler.PATH)
public class TagControler {

    public static final String PATH = "/tags";

    private TagService tagService;

    @Autowired
    public void TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> findByID(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(tagService.findById(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody TagRequestDTO newTag) {
        try {
            TagService.insert(newTag);
            return ResponseEntity.status(HttpStatus.CREATED).body(tagService.insert(newTag));
        } catch (Error e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            TagService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findTags(@RequestParam(required = false) String name) {
        if (StringUtils.isNotBlank(name)) {
            return ResponseEntity.ok(tagService.findByName(name));
        }
        return ResponseEntity.ok(tagService.findAll());
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, TagRequestDTO tagRequestDTO) {
        try {
            tagService.update(tagRequestDTO, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Error e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}
