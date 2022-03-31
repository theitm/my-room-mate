package motelRoom.repository.addressRepository;

import motelRoom.entity.addressEntity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {
}
