package ch.bbcag.backend.todolist.tag;

import ch.bbcag.backend.todolist.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("SELECT i FROM Tag i WHERE i.name LIKE CONCAT('%', :name, '%')")
    List<Item> findByName(String name);

}
