package motelRoom.repository;

import motelRoom.entity.WaitingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingListEntity, UUID> {
    List<WaitingListEntity> getAllByUserId(UUID id);
    List<WaitingListEntity> findByUserIdOrderByDateTimeDesc(UUID id);
    List<WaitingListEntity> findByOrderByDateTimeDesc();
}

