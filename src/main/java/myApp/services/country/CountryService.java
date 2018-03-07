package myApp.services.country;

import myApp.components.hierarchy.Country;
import myApp.repositories.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country save(Country location) {
        return countryRepository.save(location);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }
}
