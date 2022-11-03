package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findAllByIsDeleted(boolean isDelete);

    @Query(value = "Select *from customer where is_delete = ?1 and customer_id = ?2", nativeQuery = true)
    List<Staff> findByIsDelete(boolean isDelete, int id);

    @Query(value = "Select *from customer where is_delete = :delete AND customer_id = :id", nativeQuery = true)
    List<Staff> findByIsDelete2(@Param("delete") boolean isDelete, @Param("id") int id);

    List<Staff> findAllByStaffId(int id);

    Staff findByStaffId(int id);
}