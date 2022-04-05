package motelRoom.repository;

import motelRoom.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    @Query("SELECT u from RoomEntity u where u.user_id = :id")
    List<RoomEntity> findRoomByUserId(@Param("id") UUID user_id);
}
