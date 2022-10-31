package id.sinaukoding23.latihan.repository;


import id.sinaukoding23.latihan.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    List<Staff> findAllByIsDeleted(boolean isDelete);
}
