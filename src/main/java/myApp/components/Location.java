package myApp.components;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "location")
@DiscriminatorValue( value = "location" )
public class Location extends AbstractEntity {
    @ManyToOne
    private AbstractEntity city;

    @ManyToOne
    private AbstractEntity county;

    @ManyToOne
    private AbstractEntity country;

    @Column(name = "averagePricePerDay", nullable = false)
    private Float averagePricePerDay;

    @Column(name = "activities", nullable = false)
    private ArrayList<String> activities;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Override
    public String toString() {
        return "Location{" +
                "city=" + city +
                ", county=" + county +
                ", country=" + country +
                ", averagePricePerDay=" + averagePricePerDay +
                ", activities=" + activities +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public Location(String name, AbstractEntity city, AbstractEntity county, AbstractEntity country, Float averagePricePerDay, ArrayList<String> activities, Date startDate, Date endDate) {
        super(name);
        this.city = city;
        this.county = county;
        this.country = country;
        this.averagePricePerDay = averagePricePerDay;
        this.activities = activities;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (county != null ? !county.equals(location.county) : location.county != null) return false;
        if (country != null ? !country.equals(location.country) : location.country != null) return false;
        if (averagePricePerDay != null ? !averagePricePerDay.equals(location.averagePricePerDay) : location.averagePricePerDay != null)
            return false;
        if (activities != null ? !activities.equals(location.activities) : location.activities != null) return false;
        if (startDate != null ? !startDate.equals(location.startDate) : location.startDate != null) return false;
        return endDate != null ? endDate.equals(location.endDate) : location.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (averagePricePerDay != null ? averagePricePerDay.hashCode() : 0);
        result = 31 * result + (activities != null ? activities.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    public AbstractEntity getCity() {

        return city;
    }

    public void setCity(AbstractEntity city) {
        this.city = city;
    }

    public AbstractEntity getCounty() {
        return county;
    }

    public void setCounty(AbstractEntity county) {
        this.county = county;
    }

    public AbstractEntity getCountry() {
        return country;
    }

    public void setCountry(AbstractEntity country) {
        this.country = country;
    }

    public Float getAveragePricePerDay() {
        return averagePricePerDay;
    }

    public void setAveragePricePerDay(Float averagePricePerDay) {
        this.averagePricePerDay = averagePricePerDay;
    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
