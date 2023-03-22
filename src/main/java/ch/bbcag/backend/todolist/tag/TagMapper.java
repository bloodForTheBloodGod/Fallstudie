package ch.bbcag.backend.todolist.tag;

public class TagMapper {

    public static TagResponseDTO toResponseDTO(Tag tag) {
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
