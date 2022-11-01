package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomeStoreDTO extends BaseDTO {

        private Integer StoreId;

        private String storeName;

        private String phone;

        private String email;

        private String street;

        private String city;

        private String state;

        private String zipCode;
}

