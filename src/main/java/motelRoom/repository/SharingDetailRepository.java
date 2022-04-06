package motelRoom.repository;

import motelRoom.entity.RoomEntity;
import motelRoom.entity.SharingDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SharingDetailRepository extends JpaRepository<SharingDetailEntity, UUID> {
//    Integer deleteBySharingId(UUID sharing_id);
    @Query("SELECT u from SharingDetailEntity u where u.sharing_id = :sharing_detail_id")
    List<SharingDetailEntity> findSDBySharingId(@Param("sharing_detail_id") UUID sharing_id);
}
