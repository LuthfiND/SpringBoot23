package id.sinaukoding23.latihan.model.embeddables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StocksKey implements Serializable {
    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "product_id")
    private Integer productId;
}