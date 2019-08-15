package net.gabrielkovacs.coco.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="stockitem")
class StockItem{

    @Id
    @Column(name="id")
    private long id;
    
    @Column(name="saleprice")
    private double salePrice;
    @Column(name="amount")
    private int amount;
    @Column(name="minstock")
    private int minStock;
    @Column(name="maxstock")
    private int maxStock;
    
    protected StockItem(){}

    protected StockItem(double salePrice, int amount, int minStock, int maxStock){
        this.salePrice = salePrice;
        this.amount = amount;
        this.minStock = minStock;
        this.maxStock = maxStock;
    }

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storeid")
    private Store store;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinStock() {
        return this.minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getMaxStock() {
        return this.maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public Long getProductId(){
        return product.getId();
    }

    public void setProductId(long id){
        product.setId(id);
    }

    public Long getStoreId(){
        return store.getId();
    }

    public void setStoreId(long id){
        store.setId(id);
    }

}