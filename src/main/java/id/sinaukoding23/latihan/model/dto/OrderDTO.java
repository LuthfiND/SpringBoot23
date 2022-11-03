package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderDTO extends BaseDTO  {

    private Integer orderId;

    private Integer customerId;

    private Byte orderStatus;

    private java.sql.Date orderDate;

    private java.sql.Date requiredDate;

    private java.sql.Date  shippedDate;

    private CustomerDTO customer;

    private StaffDTO staff;

    private StoreDTO store;


}


