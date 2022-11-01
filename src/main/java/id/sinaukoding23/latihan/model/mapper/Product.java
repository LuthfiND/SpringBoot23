package id.sinaukoding23.latihan.model.mapper;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer productId;

    @Column
    private String productName;

    @Column
    private Short modelYear;

    @Column
    private BigDecimal listPrice;
}