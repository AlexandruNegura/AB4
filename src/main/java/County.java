import java.util.ArrayList;
import java.util.HashMap;

public class County extends AbstractEntity{
    private HashMap<String, AbstractEntity> cities;
    private AbstractEntity country;

    public County(String name, HashMap<String, AbstractEntity> cities, AbstractEntity country) {
        super(name, EntityType.COUNTY);
        this.cities = cities;
        this.country = country;
    }

    public HashMap<String, AbstractEntity> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, AbstractEntity> cities) {
        this.cities = cities;
    }
}
