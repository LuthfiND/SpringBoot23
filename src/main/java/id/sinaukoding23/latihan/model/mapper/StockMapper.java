package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Stocks;
import id.sinaukoding23.latihan.model.dto.StockDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    Stocks dtoToEntity(StockDTO dto);

    StockDTO entityToDto(Stocks param);

    List<Stocks> toEntityList(List<StockDTO> data);

    List<StockDTO> toDtoList(List<Stocks> data);
}