package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class StaffDTO extends BaseDTO  {

    private Integer staffId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Byte active;

    private StoreDTO store;

    private StaffDTO manager;
}


