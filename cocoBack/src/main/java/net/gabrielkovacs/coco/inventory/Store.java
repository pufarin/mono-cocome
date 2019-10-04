package net.gabrielkovacs.coco.inventory;

import net.gabrielkovacs.coco.inventory.uc6.TradingEnterprise;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="store")
public class Store {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;
    @Column(name="location")
    private String location;

    protected Store(){}

    public Store(long id){
        this.id = id;
    }

    public Store (String name, String location){
        this.name = name;
        this.location = location;
    }

    @OneToMany(mappedBy = "store")
    private Collection<StockItem> stockItem;
    
    @OneToMany(mappedBy = "store")
    private Collection<ProductOrder> productOrder;

    @ManyToOne
    @JoinColumn(name = "tradingenterpriseid")
    private TradingEnterprise  tradingEnterprise;

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

    public Long getTradingEntepriseId() { return this.tradingEnterprise.getId(); }

    public void setTradingEnterpriseId(long id) {this.tradingEnterprise.setId(id); }
}