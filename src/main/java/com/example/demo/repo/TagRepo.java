package com.example.demo.repo;

import com.example.demo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {
    Tag findTagByName(String name);
    List<Tag> findTagsByNameContainingIgnoreCase(String name);

    List<Tag> findTagsByParentContainingIgnoreCase(String parent);
}
