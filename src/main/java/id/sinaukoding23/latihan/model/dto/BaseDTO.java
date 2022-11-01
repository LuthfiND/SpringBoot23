package id.sinaukoding23.latihan.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedDate;
}