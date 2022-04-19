package motelRoom.repository;

import motelRoom.entity.RoomSharingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RoomSharingRepository extends JpaRepository<RoomSharingEntity, UUID> {
}
