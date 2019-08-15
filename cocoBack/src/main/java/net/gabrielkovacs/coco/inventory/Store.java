package net.gabrielkovacs.coco.inventory;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
class Store {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;
    @Column(name="location")
    private String location;

    protected Store(){}

    public Store (String name, String location){
        this.name = name;
        this.location = location;
    }

    @OneToMany(mappedBy = "store")
    private Collection<StockItem> stockItem;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}