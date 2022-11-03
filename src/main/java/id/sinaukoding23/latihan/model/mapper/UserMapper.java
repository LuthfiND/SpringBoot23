package id.sinaukoding23.latihan.model.mapper;

import id.sinaukoding23.latihan.model.User;
import id.sinaukoding23.latihan.model.dto.ResponseAuthDTO;
import id.sinaukoding23.latihan.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToEntity(UserDTO dto);

    UserDTO entityToDto(User param);

    List<User> toEntityList(List<UserDTO> data);

    List<UserDTO> toDtoList(List<User> data);

    ResponseAuthDTO userToResponseAuthDTO(User param);
}