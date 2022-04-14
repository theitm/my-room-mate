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
    /**.....Query to find document by typeId ...........**/
    @Query("SELECT u from DocumentEntity u where u.typeId = :id")
    List<DocumentEntity> queryFindByTypeId(@Param("id") UUID typeId);
}
