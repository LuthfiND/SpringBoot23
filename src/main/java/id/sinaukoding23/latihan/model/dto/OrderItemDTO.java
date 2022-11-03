package id.sinaukoding23.latihan.model.dto;

import id.sinaukoding23.latihan.model.Order;
import id.sinaukoding23.latihan.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter

public class OrderItemDTO extends BaseDTO  {

    private Integer itemId;

    private Integer quantity;

    private BigDecimal listPrice;

    private BigDecimal discount;

    private OrderDTO order;

    private ProductDTO product;


}

