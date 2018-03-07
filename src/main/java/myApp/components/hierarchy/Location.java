package myApp.components.hierarchy;

import myApp.components.activities.Activity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "location")
@DiscriminatorValue(value = "location")
public class Location extends AbstractEntity implements Serializable {
    @Column(name = "averagePricePerDay",
            nullable = false)
    private Float averagePricePerDay;

    @ManyToMany(mappedBy = "locations",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    private Set<Activity> activities = new HashSet<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "endDate")
    private Calendar endDate;

    public Location(String name, AbstractEntity parentEntity, Float averagePricePerDay, Calendar startDate, Calendar endDate) {
        super(name, parentEntity);
        this.averagePricePerDay = averagePricePerDay;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Location() {
        super();
    }

    public Float getAveragePricePerDay() {
        return averagePricePerDay;
    }

    public void setAveragePricePerDay(Float averagePricePerDay) {
        this.averagePricePerDay = averagePricePerDay;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name = " + getName() +
                ", averagePricePerDay = " + averagePricePerDay +
                ", activities = " + activities +
                ", startDate = " + startDate.getTime() +
                ", endDate = " + endDate.getTime() +
                '}';
    }
}
