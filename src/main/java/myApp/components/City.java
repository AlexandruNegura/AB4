package myApp.components;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Entity
@Table(name = "city")
@DiscriminatorValue(value = "city")
public class City extends  AbstractEntity{

    @OneToMany
    private Collection<Location> locations;

    @ManyToOne
    private AbstractEntity county;



    public City(String name, ArrayList<Location> locations, AbstractEntity county) {
        super(name);
        this.locations = locations;
        this.county = county;
    }


    public void addLocation(Location location){
        locations.add(location);
    }
}
