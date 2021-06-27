package guru.springframework.repositories;

import guru.springframework.domains.UnitOfMeasure;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Unit_Of_Measure u WHERE u.id= :id",nativeQuery = true)
    int customDelete(@Param("id")Long id);
}
