package myApp.services.county;

import myApp.components.hierarchy.County;
import myApp.repositories.county.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountyService implements ICountyService {

    @Autowired
    private CountyRepository countyRepository;

    @Override
    public List<County> findAll() {
        return countyRepository.findAll();
    }

    @Override
    public County save(County location) {
        return countyRepository.save(location);
    }

    @Override
    public County findByName(String name) {
        return countyRepository.findByName(name);
    }
}
