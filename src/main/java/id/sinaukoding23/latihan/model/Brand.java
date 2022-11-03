package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer brandId;

    @Column
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Product> productList;
}

