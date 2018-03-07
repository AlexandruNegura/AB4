package myApp.components.activities;

import myApp.components.hierarchy.Location;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "activity")
    private String activity;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "activity_location",
               joinColumns = {@JoinColumn(name = "activity_id",
                                          referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "location_id",
                                                 referencedColumnName = "id")})
    private List<Location> locations = new ArrayList<>();

    public Activity(String activity, Location location) {
        this.activity = activity;
        locations.add(location);
    }

    public Activity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity1 = (Activity) o;

        if (!activity.equals(activity1.activity)) return false;
        return locations.equals(activity1.locations);
    }

    @Override
    public int hashCode() {
        int result = activity.hashCode();
        result = 31 * result + locations.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                '}';
    }
}
