package motelRoom.repository;

import motelRoom.entity.SharingDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SharingDetailRepository extends JpaRepository<SharingDetailEntity, UUID> {
    @Query("SELECT u from SharingDetailEntity u WHERE u.userId = :userId")
    SharingDetailEntity findByUserId(UUID userId);
}
