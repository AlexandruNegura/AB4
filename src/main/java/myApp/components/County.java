package myApp.components;

import java.util.HashMap;

public class County extends AbstractEntity{
    private HashMap<String, AbstractEntity> cities;
    private AbstractEntity country;

    public County(String name, HashMap<String, AbstractEntity> cities) {
        super(name);
        this.cities = cities;
    }

    public HashMap<String, AbstractEntity> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, AbstractEntity> cities) {
        this.cities = cities;
    }
}
