package motelRoom.mapper;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity fromUserEntityCreateDtoToEntity (UserCreateDto userCreateDto);
    UserDetailDto fromUserEntityToUserCrateDto (UserEntity userEntity);
}
