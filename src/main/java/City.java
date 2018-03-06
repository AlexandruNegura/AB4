import java.util.ArrayList;
import java.util.HashMap;

public class City extends  AbstractEntity{
    private HashMap<String, AbstractEntity> locations;
    private AbstractEntity county;

    public City(String name, HashMap<String, AbstractEntity> locations, AbstractEntity county) {
        super(name, EntityType.CITY);
        this.locations = locations;
        this.county = county;
    }

    public HashMap<String, AbstractEntity> getLocations() {
        return locations;
    }

    public void setLocations(HashMap<String, AbstractEntity> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location){
        locations.put(location.name, location);
    }
}
