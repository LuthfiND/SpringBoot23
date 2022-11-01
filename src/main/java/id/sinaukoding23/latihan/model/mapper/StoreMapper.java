package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Store;
import id.sinaukoding23.latihan.model.dto.CustomeStoreDTO;
import id.sinaukoding23.latihan.model.dto.StoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    Store dtoToEntity(StoreDTO dto);

    StoreDTO entityToDto(Store param);

    List<StoreDTO> toDtoList(List<Store> data);

    CustomeStoreDTO fromStoreToResponse(StoreDTO param);

    List<CustomeStoreDTO> toStoreResponse(List<StoreDTO> data);
}
