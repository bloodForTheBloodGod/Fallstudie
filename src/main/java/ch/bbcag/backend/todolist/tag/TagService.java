package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagResponseDTO> findAll() {
        List<Tag> tag = tagRepository.findAll();
        return tag.stream().map(TagMapper::toResponseDTO).toList();
    }

    public TagResponseDTO findById(Integer id) {
        return TagMapper.toResponseDTO(tagRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public List<TagResponseDTO> findByName(String name) {
        List<Tag> tags = tagRepository.findByName(name);
        return tags.stream().map(TagMapper::toResponseDTO).toList();
    }

    public static void deleteById(Integer id) {
        tagRepository.deleteById(id);
    }

    public static TagResponseDTO insert(TagRequestDTO tagRequestDTO) {
        return TagMapper.toResponseDTO(tagRepository.save(TagMapper.fromRequestDTO(tagRequestDTO)));
    }

    public TagResponseDTO update(TagRequestDTO tagRequestDTO, Integer tagId) {
        Tag existingTag = tagRepository.findById(tagId).orElseThrow(EntityNotFoundException::new);
        Tag changingTag = TagMapper.fromRequestDTO(tagRequestDTO);
        mergeTag(existingTag, changingTag);
        return TagMapper.toResponseDTO(tagRepository.save(existingTag));
    }

    private void mergeTag(Tag existingTag, Tag changingTag) {

        if (changingTag.getName() != null) {
            existingTag.setName(changingTag.getName());
        }
        if (changingTag.getLinkedItems() != null) {
            existingTag.setLinkedItems(changingTag.getLinkedItems());
        }


    }
}
