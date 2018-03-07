package myApp.repositories.city;

import myApp.components.hierarchy.AbstractEntity;
import myApp.components.hierarchy.City;
import myApp.components.hierarchy.Location;
import myApp.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends BaseRepository<City, Long> {

    City findByName(String name);

    List<City> findAllByParentEntity(AbstractEntity abstractEntity);

}
