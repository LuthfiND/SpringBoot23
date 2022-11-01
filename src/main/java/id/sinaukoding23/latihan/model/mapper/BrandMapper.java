package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Brand;
import id.sinaukoding23.latihan.model.dto.BrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand dtoToEntity(BrandDTO dto);

    BrandDTO entityToDto(Brand param);

    List<BrandDTO> toDtoList(List<Brand> data);
    }
