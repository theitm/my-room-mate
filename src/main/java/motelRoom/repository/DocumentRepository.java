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
    @Query("SELECT u from DocumentEntity u where u.parentId = :id and u.parentType = 2")
    List<DocumentEntity> findAllByParentIdEvaluation(@Param("id") UUID parentId);
    @Query("SELECT u from DocumentEntity u where u.parentId = :id and u.parentType = 1")
    List<DocumentEntity> findAllByParentIdRoom(@Param("id") UUID parentId);
}
