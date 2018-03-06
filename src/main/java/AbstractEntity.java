import java.util.ArrayList;

public abstract class AbstractEntity {
    protected String name;
    protected EntityType type;

    public AbstractEntity(String name, EntityType type) {
        this.name = name;
        this.type = type;
    }

    public boolean isRegion(){
        return type != EntityType.LOCATION;
    }

    public boolean isLocation(){
        return type == EntityType.LOCATION;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }
}
