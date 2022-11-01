package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.Staff;
import id.sinaukoding23.latihan.model.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);
    Staff dtoToEntity(StaffDTO dto);

    StaffDTO entityToDto(Staff param);

    List<StaffDTO> toDtoList(List<Staff> data);
}
