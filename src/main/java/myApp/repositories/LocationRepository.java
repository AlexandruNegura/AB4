package myApp.repositories;

import myApp.components.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends BaseRepository<Location, Long> {

}
