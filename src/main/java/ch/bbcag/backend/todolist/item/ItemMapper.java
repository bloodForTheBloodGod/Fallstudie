package ch.bbcag.backend.todolist.item;

import ch.bbcag.backend.todolist.person.Person;

class ItemMapper {
    public static ItemResponseDTO toResponseDTO(Item item) {
        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        itemResponseDTO.setId(item.getId());
        itemResponseDTO.setName(item.getName());
        itemResponseDTO.setDescription(item.getDescription());
        itemResponseDTO.setCreatedAt(item.getCreatedAt());
        itemResponseDTO.setDoneAt(item.getDoneAt());
        itemResponseDTO.setDeletedAt(item.getDeletedAt());
        itemResponseDTO.setPersonId(item.getPerson().getId());
        return itemResponseDTO;
    }

    public static Item fromRequestDTO(ItemRequestDTO itemRequestDTO) {
        Item item = new Item();
        item.setName(itemRequestDTO.getName());
        item.setDescription(itemRequestDTO.getDescription());
        item.setDoneAt(itemRequestDTO.getDoneAt());
        item.setDeletedAt(itemRequestDTO.getDeletedAt());
        if (itemRequestDTO.getPersonId() != null) {
            item.setPerson(new Person(itemRequestDTO.getPersonId()));
        } else {
            item.setPerson(null);
        }
        return item;
    }
}