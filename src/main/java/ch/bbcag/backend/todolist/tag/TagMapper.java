package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.tag.Tag;
public class TagMapper {

    public static TagResponseDTO tagResponseDTO(Tag tag) {
        TagResponseDTO tagResponseDTO = new TagResponseDTO();
        tagResponseDTO.setId(tag.getId());
        tagResponseDTO.setItemIds(tag.getLinkedItems());

        return tagResponseDTO;
    }

    public static Tag fromRequestDTO(TagRequestDTO tagRequestDTO) {
        Tag tag = new Tag();
        tag.setName(tagRequestDTO.getName());

       return tag;
    }
}
