package id.sinaukoding23.latihan.repository;


import id.sinaukoding23.latihan.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {

    List<Store> findAllByIsDeleted(boolean isDelete);
}
