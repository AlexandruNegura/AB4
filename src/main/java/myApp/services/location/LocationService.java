package myApp.services.location;

import myApp.components.hierarchy.AbstractEntity;
import myApp.components.hierarchy.Location;
import myApp.repositories.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationService implements ILocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location findByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public List<Location> findAllByParentEntity(AbstractEntity abstractEntity) {
        return locationRepository.findAllByParentEntity(abstractEntity);
    }

    @Override
    public Location findMinimumAvaragePerDay() {
        return locationRepository.findMinimumAvaragePerDay();
    }
}
