package id.sinaukoding23.latihan.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class ProductDTO extends BaseDTO  {

    private Integer productId;

    private String productName;

    private Short modelYear;

    private BigDecimal listPrice;

}


