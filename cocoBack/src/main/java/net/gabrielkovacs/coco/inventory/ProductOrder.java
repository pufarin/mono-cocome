package net.gabrielkovacs.coco.inventory;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="productorder")
public class ProductOrder{

    @Id
    @Column(name="id")
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "mySeqGen")
    private long id;
    
    private Date deliveryDate;
    private Date orderingDate;

    public ProductOrder(){}


    public ProductOrder(long id, Date deliveryDate, Date orderingDate) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.orderingDate = orderingDate;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeid", referencedColumnName = "id")
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

    public void setStore(Store store){
        this.store = store;
    }

}