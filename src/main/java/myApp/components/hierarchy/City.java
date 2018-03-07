package myApp.components.hierarchy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
@DiscriminatorValue(value = "city")
public class City extends AbstractEntity implements Serializable {

    public City(String name, AbstractEntity parentEntity) {
        super(name, parentEntity);
    }

    public City() {
    }
}
