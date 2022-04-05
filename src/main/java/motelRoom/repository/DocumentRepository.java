package motelRoom.repository;

import motelRoom.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository <DocumentEntity, UUID> {
    /**.....Query to find document by room_id ...........**/
    @Query("SELECT u from DocumentEntity u where u.roomId = :id")
    List<DocumentEntity> myCustomQuery2(@Param("id") UUID roomId);
}
