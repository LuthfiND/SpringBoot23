package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByIsDeleted(boolean isDelete);
}
