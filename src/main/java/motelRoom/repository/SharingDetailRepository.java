package motelRoom.repository;

import motelRoom.entity.SharingDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SharingDetailRepository extends JpaRepository<SharingDetailEntity, UUID> {
//    @Query("SELECT u FROM User u WHERE u.status = 1")
//    Collection<User> findAllActiveUsers();

    @Query("SELECT u from SharingDetailEntity u WHERE u.user_id = :id")
    SharingDetailEntity findByUserId(UUID id);
}
