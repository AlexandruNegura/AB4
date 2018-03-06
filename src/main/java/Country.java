import java.util.ArrayList;
import java.util.HashMap;

public class Country extends AbstractEntity{
    private HashMap<String, AbstractEntity> counties;

    public Country(String name, HashMap<String, AbstractEntity> counties) {
        super(name, EntityType.COUNTRY);
        this.counties = counties;
    }
}
