import java.util.ArrayList;
import java.util.Date;

public class Location extends AbstractEntity {
    private AbstractEntity city;
    private Float averagePricePerDay;
    private ArrayList<String> activities;
    private Date startDate;
    private Date endDate;

    public Location(String name, AbstractEntity city, Float averagePricePerDay, ArrayList<String> activities, Date startDate, Date endDate) {
        super(name, EntityType.LOCATION);
        this.city = city;
        this.averagePricePerDay = averagePricePerDay;
        this.activities = activities;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
