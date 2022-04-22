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
    List<RoomEntity> searchFirstByCapacityAndAndPriceOrAndRoomIdAndPrice(float capacity, float price);
}
