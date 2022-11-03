package id.sinaukoding23.latihan.model;

import id.sinaukoding23.latihan.model.embeddables.StocksKey;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Stocks {
    @EmbeddedId
    StocksKey id = new StocksKey();

    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer quantity;

}