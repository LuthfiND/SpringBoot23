package id.sinaukoding23.latihan.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter

public class BrandDTO extends BaseDTO  {

    private Integer brandId;

    private String brandName;

}
