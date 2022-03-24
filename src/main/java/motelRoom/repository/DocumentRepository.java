package motelRoom.repository;

import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface DocumentRepository extends JpaRepository <DocumentEntity, UUID> {

    @Query(value = "select * from document u where u.room_id = :room_id", nativeQuery = true)
    List<DocumentEntity> myCustomQuery2(String room_id);

}
