package motelRoom.mapper;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.dto.user.UserLogin;
import motelRoom.entity.UserEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    UserEntity fromUserEntityCreateDtoToEntity (UserCreateDto userCreateDto);

    UserDetailDto fromUserEntityToUserCrateDto (UserEntity userEntity);

    List<UserLogin> fromListDtosToEntities(List<UserEntity> userEntities);

    List<UserDetailDto> fromEntityToDto ( List<UserEntity> userEntities);
}
