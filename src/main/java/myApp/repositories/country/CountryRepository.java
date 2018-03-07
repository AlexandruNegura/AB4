package myApp.repositories.country;

import myApp.components.hierarchy.Country;
import myApp.components.hierarchy.County;
import myApp.components.hierarchy.Location;
import myApp.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends BaseRepository<Country, Long> {

    Country findByName(String name);

}
