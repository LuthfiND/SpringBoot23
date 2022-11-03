package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findAllByIsDeleted(boolean isDelete);

    List<OrderItem> findByOrder_OrderId(Integer id);
}