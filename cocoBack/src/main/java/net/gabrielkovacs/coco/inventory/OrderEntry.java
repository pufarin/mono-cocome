package net.gabrielkovacs.coco.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderentry")
public class OrderEntry{

    @Id
    @Column(name="id")
    private long id;

    @Column(name="amount")
    private int amount;


    protected OrderEntry(){}


    public OrderEntry(long id, int amount) {
        this.id = id;
        this.amount = amount;
    }


    @ManyToOne
    @JoinColumn(name = "productorderid")
    private ProductOrder productOrder;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}