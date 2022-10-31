package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer StoreId;

    @Column
    private String storeName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;
}
