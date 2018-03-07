package myApp.services.city;

import myApp.components.hierarchy.AbstractEntity;
import myApp.components.hierarchy.City;
import myApp.components.hierarchy.Location;

import java.util.List;

public interface ICityService {
    public List<City> findAll();
    public City save(City location);
    public City findByName(String name);
    public List<City> findAllByParentEntity(AbstractEntity abstractEntity);
}
