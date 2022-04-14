package motelRoom.mapper;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity fromUserCreateDto(UserCreateDto userCreateDto);
    UserDetailDto fromEntityToDto (UserEntity userEntity);
    List<UserDetailDto> fromListEntityToDto(List<UserEntity> userEntities);
}
