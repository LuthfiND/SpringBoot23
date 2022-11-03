package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter

public class CategoryDTO extends BaseDTO  {

    private Integer categoryId;
    private String categoryName;
}
