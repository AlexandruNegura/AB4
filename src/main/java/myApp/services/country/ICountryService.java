package myApp.services.country;

import myApp.components.hierarchy.Country;

import java.util.List;

public interface ICountryService {
    public List<Country> findAll();
    public Country save(Country location);
    public Country findByName(String name);
}
