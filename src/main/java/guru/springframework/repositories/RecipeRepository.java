package guru.springframework.repositories;

import guru.springframework.domains.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription(String description);


    @Transactional
    Long deleteByDescription(String description);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Recipe r WHERE r.id= :id",nativeQuery = true)
    int customDelete(@Param("id")Long id);
}
