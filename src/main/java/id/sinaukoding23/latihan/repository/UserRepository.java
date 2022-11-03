package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByIsDeleted(boolean isDelete);

    User findByUsername(String username);
}