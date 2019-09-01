package net.gabrielkovacs.coco.inventory;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productorder")
public class ProductOrder{

    @Id
    @Column(name="id")
    private long id;
    
    private Date deliveryDate;
    private Date orderingDate;

    protected ProductOrder(){}


    public ProductOrder(long id, Date deliveryDate, Date orderingDate) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.orderingDate = orderingDate;
    }



    @ManyToOne
    @JoinColumn(name = "storeid")
    private Store store;

    @OneToMany(mappedBy = "productOrder")
    private Collection<OrderEntry> orderEntry;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getOrderingDate() {
        return this.orderingDate;
    }

    public void setOrderingDate(Date orderingDate) {
        this.orderingDate = orderingDate;
    }
    
    public Long getStoreId(){
        return store.getId();
    }

    public void setStoreId(long id){
        store.setId(id);
    }

}