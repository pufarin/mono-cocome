package net.gabrielkovacs.coco.inventory;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
class Product {

    @Id
    @Column(name="id")
    private long id;

    public Collection<StockItem> getStockItem() {
        return this.stockItem;
    }

    public void setStockItem(Collection<StockItem> stockItem) {
        this.stockItem = stockItem;
    }

    @Column(name="barcode")
    private int barcode;
    @Column(name="name")
    private String name;
    @Column(name="purchaseprice")
    private double purchasePrice;
     
    
    protected Product(){}

    public Product(int barcode, String name, double purchasePrice){
        this.barcode = barcode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    @OneToMany(mappedBy = "product")
    private Collection<StockItem> stockItem;



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBarcode() {
        return this.barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

}