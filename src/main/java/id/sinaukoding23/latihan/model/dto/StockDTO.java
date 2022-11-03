package id.sinaukoding23.latihan.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StockDTO {
    private ProductDTO product;

    private StoreDTO store;

    private Integer quantity;
}
