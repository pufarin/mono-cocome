package net.gabrielkovacs.coco.inventory.uc3;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.gabrielkovacs.coco.inventory.Product;


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
