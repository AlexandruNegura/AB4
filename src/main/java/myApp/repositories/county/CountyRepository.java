package myApp.repositories.county;

import myApp.components.hierarchy.County;
import myApp.components.hierarchy.Location;
import myApp.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends BaseRepository<County, Long> {

    County findByName(String name);

}
