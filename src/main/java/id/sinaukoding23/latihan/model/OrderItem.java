package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "order_items")
@Entity
@Setter
@Getter
public class OrderItem extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column
    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private BigDecimal listPrice;

    @Column(columnDefinition = "DECIMAL(4,2)")
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}