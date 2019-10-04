package net.gabrielkovacs.coco.inventory.uc3;

import java.util.Collection;

import javax.persistence.*;

import net.gabrielkovacs.coco.inventory.Product;
import net.gabrielkovacs.coco.inventory.uc6.TradingEnterprise;


@Entity
@Table(name = "productsuplier")
public class ProductSuplier{

    @Id
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name; 

    protected ProductSuplier(){}

    public ProductSuplier(long id, String name){
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "productSuplier")
    private Collection<Product> product;

    @ManyToMany(mappedBy = "productSupliers")
    private Collection<TradingEnterprise> tradingEnterprises;


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


}
