package myApp.components.hierarchy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
@DiscriminatorValue(value = "country")
public class Country extends AbstractEntity implements Serializable {

    public Country(String name, AbstractEntity parentEntity) {
        super(name, parentEntity);
    }

    public Country() {
    }
}
