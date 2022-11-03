package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO{
    private Integer userId;

    private String username;

    private String profileName;

    private String password;

    private boolean isActive;

    private StaffDTO staff;
}