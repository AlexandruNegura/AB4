package myApp.repositories.location;

import myApp.components.hierarchy.AbstractEntity;
import myApp.components.hierarchy.Location;
import myApp.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends BaseRepository<Location, Long> {

    Location findByName(String name);

    List<Location> findAllByParentEntity(AbstractEntity abstractEntity);

    @Query(value = "select l from Location l where averagePricePerDay = (SELECT MIN(averagePricePerDay) from Location )")
    Location findMinimumAvaragePerDay();

}
