package myApp.components.hierarchy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "county")
@DiscriminatorValue(value = "county")
public class County extends AbstractEntity implements Serializable {

    public County(String name, AbstractEntity parentEntity) {
        super(name, parentEntity);
    }

    public County() {
    }
}
