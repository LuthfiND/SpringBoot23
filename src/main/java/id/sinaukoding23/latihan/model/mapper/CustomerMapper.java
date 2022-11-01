package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Customer;
import id.sinaukoding23.latihan.model.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer dtoToEntity(CustomerDTO dto);

    CustomerDTO entityToDto(Customer param);

    List<CustomerDTO> toDtoList(List<Customer> data);
}
