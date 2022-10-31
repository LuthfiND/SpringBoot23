package id.sinaukoding23.latihan.repository;


import id.sinaukoding23.latihan.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByIsDeleted(boolean isDelete);
}
