package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseAuthDTO {
    private Integer userId;

    private String username;

    private String profileName;

    private String password;

    private String token;

    private StaffDTO staff;
}