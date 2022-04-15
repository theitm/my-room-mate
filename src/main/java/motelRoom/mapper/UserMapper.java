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
import motelRoom.dto.user.UserLogin;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {


    UserEntity fromUserEntityCreateDtoToEntity (UserCreateDto userCreateDto);

    UserDetailDto fromUserEntityToUserCrateDto (UserEntity userEntity);

    List<UserLogin> fromListDtosToEntities(List<UserEntity> userEntities);

}
