package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Product;
import id.sinaukoding23.latihan.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product dtoToEntity(ProductDTO dto);

    ProductDTO entityToDto(Product param);

    List<Product> toEntityList(List<ProductDTO> data);

    List<ProductDTO> toDtoList(List<Product> data);
}