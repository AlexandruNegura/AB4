package myApp.services.county;

import myApp.components.hierarchy.County;

import java.util.List;

public interface ICountyService {
    public List<County> findAll();
    public County save(County location);
    public County findByName(String name);
}
