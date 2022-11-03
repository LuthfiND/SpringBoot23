package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByIsDeleted(boolean isDelete);

    @Query(value = "Select *from customer where is_delete = ?1 and customer_id = ?2", nativeQuery = true)
    List<Product> findByIsDelete(boolean isDelete, int id);

    @Query(value = "Select *from customer where is_delete = :delete AND customer_id = :id", nativeQuery = true)
    List<Product> findByIsDelete2(@Param("delete") boolean isDelete, @Param("id") int id);

    List<Product> findAllByProductId(int id);

    Product findByProductId(int id);
}