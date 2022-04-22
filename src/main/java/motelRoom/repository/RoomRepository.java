package motelRoom.repository;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    List<RoomEntity> searchAllByUserIdOrProvinceIdOrPriceOrCapacity(UUID userId, int provinceId, float price, float capacity);
    List<RoomEntity> searchRoomEntitiesByPriceAndCapacityOrProvinceIdAndDistrictId(float price, float capacity, int provinceId, int districtId);
    List<RoomEntity> searchRoomEntitiesByProvinceIdAndPrice(int provinceId, float price);
    List<RoomEntity> searchRoomEntitiesByProvinceIdAndCapacity(int provinceId, float capacity);
}
