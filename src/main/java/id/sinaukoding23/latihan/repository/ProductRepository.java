package id.sinaukoding23.latihan.repository;


import id.sinaukoding23.latihan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByIsDeleted(boolean isDelete);
}
