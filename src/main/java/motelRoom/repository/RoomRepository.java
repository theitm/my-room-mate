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
    @Query(value = "select * from table_room where (province_id =:provinceId and capacity=:capacity and price=:price) " +
            "or(province_id = :provinceId and district_id=:districtId and price=:price) " +
            "or(province_id =:provinceId and district_id=:districtId and capacity=:capacity) " +
            "or(province_id = :provinceId and district_id=:districtId and ward_id=:wardId) ",nativeQuery = true)
    List<RoomEntity> multiSearch3Filter(@Param("provinceId")int provinceId,@Param("districtId")int districtId,@Param("wardId") int wardId,@Param("price")float price,@Param("capacity")float capacity);
    @Query(value = "select * from table_room where(province_id =:provinceId and district_id=:districtId and price=:price and capacity=:capacity) " +
            "or(province_id = :provinceId and district_id=:districtId and ward_id=:wardId and price=:price) " +
            "or(province_id = :provinceId and district_id=:districtId and ward_id=:wardId and capacity=:capacity)",nativeQuery = true)
    List<RoomEntity> multiSearch4Filter(@Param("provinceId")int provinceId,@Param("districtId")int districtId,@Param("wardId") int wardId,@Param("price")float price,@Param("capacity")float capacity);
    List<RoomEntity> searchRoomEntitiesByProvinceIdAndDistrictIdAndWardIdAndPriceAndCapacity(int provinceId,int districtId,int wardId, float price, float capacity);
}
