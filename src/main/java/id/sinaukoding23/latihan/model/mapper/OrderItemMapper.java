package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.OrderItem;
import id.sinaukoding23.latihan.model.dto.OrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItem dtoToEntity(OrderItemDTO dto);

    OrderItemDTO entityToDto(OrderItem param);

    List<OrderItem> toEntityList(List<OrderItemDTO> data);

    List<OrderItemDTO> toDtoList(List<OrderItem> data);
}