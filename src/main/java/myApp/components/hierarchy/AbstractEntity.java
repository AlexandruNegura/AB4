package myApp.components.hierarchy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract entity that can encapsulate a country, region, city or Location
 *
 * Will be further implemented by concrete classes
 *
 * Each AbstractEntity has a list of children and a parent. It is very similar to
 * a simple filesystem. The concrete implementations of this class are mapped int the
 * database in a hierarchical manner, the connection being made using the parent field.
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type",
                     discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="parentEntity", fetch=FetchType.EAGER,
               targetEntity=AbstractEntity.class,
               cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JsonManagedReference
    private List<AbstractEntity> subEntities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,
               cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.DETACH},
               optional = true)
    @JoinColumn(name = "parentId",
                referencedColumnName = "id")
    private AbstractEntity parentEntity;

    public AbstractEntity(String name, AbstractEntity parentEntity) {
        this.name = name;
        this.parentEntity = parentEntity;
        if (parentEntity != null) {
            parentEntity.addEntity(this);
        }
    }

    public AbstractEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AbstractEntity> getSubEntities() {
        return subEntities;
    }

    public void setSubEntities(List<AbstractEntity> subEntities) {
        this.subEntities = subEntities;
    }

    public AbstractEntity getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(AbstractEntity parentEntity) {
        this.parentEntity = parentEntity;
    }

    public void addEntity(AbstractEntity entity) {
        subEntities.add(entity);
    }
}
