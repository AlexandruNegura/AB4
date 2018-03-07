package myApp.services.location;

import myApp.components.hierarchy.AbstractEntity;
import myApp.components.hierarchy.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocationService {
    public List<Location> findAll();
    public Location save(Location location);
    public Location findByName(String name);
    public List<Location> findAllByParentEntity(AbstractEntity abstractEntity);
    public Location findMinimumAvaragePerDay();
}
