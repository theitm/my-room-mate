package motelRoom.repository;

import motelRoom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Modifying
    @Transactional
    @Query("Update UserEntity e SET e.passwords = :ps WHERE e.username = :username")
    public void updatePasswords(@Param("username") String user, @Param("ps") String pass);

}
