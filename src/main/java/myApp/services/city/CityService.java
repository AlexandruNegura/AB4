package myApp.services.city;

import myApp.components.hierarchy.AbstractEntity;
import myApp.components.hierarchy.City;
import myApp.repositories.city.CityRepository;
import myApp.repositories.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City save(City location) {
        return cityRepository.save(location);
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findAllByParentEntity(AbstractEntity abstractEntity) {
        return cityRepository.findAllByParentEntity(abstractEntity);
    }
}
